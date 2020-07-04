package com.myfun.erpWeb.managecenter.transaction.vo;

import java.io.Serializable;
import java.util.List;

public class ProcessModelStepListResultVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	List<ProcessModelStepVO> processModelStepListVO;

	public List<ProcessModelStepVO> getProcessModelStepListVO() {
		return processModelStepListVO;
	}

	public void setProcessModelStepListVO(List<ProcessModelStepVO> processModelStepListVO) {
		this.processModelStepListVO = processModelStepListVO;
	}

}
