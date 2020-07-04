<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="../common/jquery-2.1.3.min.js" type="text/javascript"></script>
<style>
html,body{width: 100%;height: 100%;margin: 0;padding: 0;overflow: hidden;}
#kujialeIframe{width: 100%;height: 100%;border: 0;z-index: -1;}
#userOption{position: absolute;top: 0px;left: 0px;width: 500px;height: 200px;background-color: #4d4d4d;z-index: 99999;}
#userOptionIframe{position: absolute;top: 0px;left: 0px;width: 500px;height: 200px;background-color: #4d4d4d;z-index: 99999;}
</style>
<body>
	<iframe id="kujialeIframe" src="${KJL_URL}"></iframe>
	<iframe id="userOptionIframe"></iframe>
	<div id="userOption">
		dasdsadasdasdas
	</div>
</body>
<script type="text/javascript">
	function setUrl(url) {
		$("#kujialeIframe").attr("src", url);
	}
</script>
</html>