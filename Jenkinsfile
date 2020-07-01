def label = "slave-${UUID.randomUUID().toString()}"

def helmLint(String chartDir) {
    sh "helm lint ${chartDir}"
}
def helmInit() {
    sh "helm init --client-only --stable-repo-url https://mirror.azure.cn/kubernetes/charts/"
}
def helmRepo(Map args) {
    sh "cat /tmp/hosts && ping registry.midland.com.cn"
    sh "helm repo add --username ${args.username} --password ${args.password} myrepo https://registry.midland.com.cn/chartrepo"

    println "update repo"
    sh "helm repo update"
    println "fetch chart package"
    sh """
      helm fetch myrepo/library/hftpublic
      tar xzvf hftpublic-0.1.0.tgz
	  sed -i 's/hftpublic/${args.name}/g' ./hftpublic/Chart.yaml
	  sed -i 's/hftpublic/${args.name}/g' ./hftpublic/values.yaml
	  sed -i 's/hftpublic/${args.name}/g' ./hftpublic/templates/deployment.yaml
	  sed -i 's/hftpublic/${args.name}/g' ./hftpublic/templates/_helpers.tpl
	  sed -i 's/hftpublic/${args.name}/g' ./hftpublic/templates/service.yaml
    """
	
}
def helmDeploy(Map args) {
    helmInit()
    helmRepo(args)

    if (args.dry_run) {
    	sh "helm upgrade --install ${args.name} hftpublic  --set api.image.repository=${args.image} --set api.image.tag=${args.tag} --set replicaCount=2 --set service.namespaces=${args.namespace}"
        echo "应用 ${args.name} 部署成功. 可以使用 helm status ${args.name} 查看应用状态${args.namespace}"
    } else {
    	sh "helm upgrade --install ${args.name} hftpublic  --set api.image.repository=${args.image} --set api.image.tag=${args.tag} --set service.namespaces=${args.namespace}"
        echo "应用 ${args.name} 部署成功. 可以使用 helm status ${args.name} 查看应用状态${args.namespace}"
    }
}

podTemplate(label: label, containers: [
  containerTemplate(name: 'maven', image: 'registry.midland.com.cn/helm/mvn-jdk8:3.6.3', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'docker', image: 'registry.midland.com.cn/helm/docker', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'kubectl', image: 'registry.midland.com.cn/helm/kubectl', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'helm', image: 'registry.midland.com.cn/helm/helm:4.5', command: 'cat', ttyEnabled: true)

], volumes: [
  hostPathVolume(mountPath: '/root/.m2', hostPath: '/root/.m2'),
  hostPathVolume(mountPath: '/tmp/jenkins/.kube', hostPath: '/root/.kube'),
  hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock')
], serviceAccount: 'jenkins') {
  node(label) {
	def dockerRegistryUrl = "registry.midland.com.cn"
	def imageEndpoint = "chartrepo"
	def projname = env.JOB_NAME
	def image = "${dockerRegistryUrl}/${imageEndpoint}/${projname}"
	def imageTag = ""
	def myRepo = ""
	def isonline = false
	def spaces = env.myuserInput

    stage('deploy') {
	withCredentials([[$class: 'UsernamePasswordMultiBinding',
	credentialsId: 'dockerhub',
	usernameVariable: 'DOCKER_HUB_USER',
	passwordVariable: 'DOCKER_HUB_PASSWORD']]) {
	container('helm') {
		helmDeploy(
            dry_run     : isonline,
            name        : "${projname}",
            chartDir    : "${projname}",
            namespace   : "${myuserInput}",
            tag         : "${imageTag}",
            image       : "${image}",
            username    : "${DOCKER_HUB_USER}",
            password    : "${DOCKER_HUB_PASSWORD}"
        )
        echo "[INFO] 部署应用成功..."
		
      }
	  }

    }
  }
}
