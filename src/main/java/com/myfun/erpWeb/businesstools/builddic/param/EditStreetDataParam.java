package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2020/2/6
 */
@ApiModel
public class EditStreetDataParam implements EncryParamIfc {

    @ApiModelProperty(value = "操作类型 1=新增 2=编辑 3=删除, 新增时参数写入到addData, 编辑时写入updateData, 删除时写入deleteData")
    private Byte type;

    @ApiModelProperty(value = "删除操作的参数")
    private DeleteData deleteData;

    @ApiModelProperty(value = "删除操作的参数")
    private AddData addData;

    @ApiModelProperty(value = "删除操作的参数")
    private UpdateData updateData;

    @ApiModel
    public static class DeleteData {

        @ApiModelProperty(value = "需要删除的主键ID")
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    @ApiModel
    public static class AddData {

        @ApiModelProperty(value = "对应的名称, 例如省份名称、城市名称")
        private String name;

        @ApiModelProperty(value = "省份,城市,行政区是从FUN_PROVINCE, FUN_CITY, FUN_REG表选择, 这里传选择的行政省市区的ID")
        private Integer funId;

        @ApiModelProperty(value = "唯一编码")
        private String code;

        @ApiModelProperty(value = "排序")
        private Integer seqNo;

        @ApiModelProperty(value = "上一级的街道相关ID, 例如操作华南地区时不传，操作街道时传用逗号隔开的商圈ID, 其他情况例如操作成都市, 这里就传四川省的ID, 天府五街就传逗号分隔商圈ID")
        private String parentId;

        @ApiModelProperty(value = "描述")
        private String remark;
        
        @ApiModelProperty(value = "行政区Ids,多个逗号隔开")
        private String regIds;
        
        @ApiModelProperty(value = "商圈Ids,多个逗号隔开")
        private String sectionIds;

        public String getRegIds() {
			return regIds;
		}

		public void setRegIds(String regIds) {
			this.regIds = regIds;
		}

		public String getSectionIds() {
			return sectionIds;
		}

		public void setSectionIds(String sectionIds) {
			this.sectionIds = sectionIds;
		}

		public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getFunId() {
            return funId;
        }

        public void setFunId(Integer funId) {
            this.funId = funId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    @ApiModel
    public static class UpdateData {

        @ApiModelProperty(value = "主键自增")
        private Integer id;

        @ApiModelProperty(value = "省份,城市,行政区是从FUN_PROVINCE, FUN_CITY, FUN_REG表选择, 这里传选择的行政省市区的ID")
        private Integer funId;

        @ApiModelProperty(value = "对应的名称, 例如省份名称、城市名称")
        private String name;

        @ApiModelProperty(value = "唯一编码")
        private String code;

        @ApiModelProperty(value = "排序")
        private Integer seqNo;

        @ApiModelProperty(value = "上一级的ID, 例如操作华南地区时不传，操作街道时传用逗号隔开的商圈ID, 其他情况例如操作成都市, 这里就传四川省的ID, 这里就传四川省的ID, 天府五街就传逗号分隔商圈ID")
        private String parentId;

        @ApiModelProperty(value = "描述")
        private String remark;
        
        @ApiModelProperty(value = "行政区Ids")
        private String regIds;
        
        @ApiModelProperty(value = "商圈Ids")
        private String sectionIds;

        public String getRegIds() {
			return regIds;
		}

		public void setRegIds(String regIds) {
			this.regIds = regIds;
		}

		public String getSectionIds() {
			return sectionIds;
		}

		public void setSectionIds(String sectionIds) {
			this.sectionIds = sectionIds;
		}

		public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getFunId() {
            return funId;
        }

        public void setFunId(Integer funId) {
            this.funId = funId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getSeqNo() {
            return seqNo;
        }

        public void setSeqNo(Integer seqNo) {
            this.seqNo = seqNo;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public DeleteData getDeleteData() {
        return deleteData;
    }

    public void setDeleteData(DeleteData deleteData) {
        this.deleteData = deleteData;
    }

    public AddData getAddData() {
        return addData;
    }

    public void setAddData(AddData addData) {
        this.addData = addData;
    }

    public UpdateData getUpdateData() {
        return updateData;
    }

    public void setUpdateData(UpdateData updateData) {
        this.updateData = updateData;
    }
}