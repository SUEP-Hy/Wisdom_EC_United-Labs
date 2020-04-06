<template>
  <div class="container">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:tbEmployee:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:tbEmployee:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:tbEmployee:edit" permsDelete="sys:tbEmployee:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面 主界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="人员基本信息ID" prop="fbasicid">
				<el-input v-model="dataForm.fbasicid" auto-complete="off" v-if="false"></el-input>
				<kt-button label="人员基本信息"  perms="sys:tbEmployeeBasic:view" @click="handleAddBasic"></kt-button>
			</el-form-item>
			<el-form-item label="联系信息ID" prop="fcontactid">
				<el-input v-model="dataForm.fcontactid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="薪酬福利ID" prop="fsalaryid">
				<el-input v-model="dataForm.fsalaryid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="合同信息ID" prop="fcontractid">
				<el-input v-model="dataForm.fcontractid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议ID" prop="fprotocolid">
				<el-input v-model="dataForm.fprotocolid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="个人经历ID" prop="fexperienceid">
				<el-input v-model="dataForm.fexperienceid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="体检信息ID" prop="fphysicalid">
				<el-input v-model="dataForm.fphysicalid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="家庭成员ID" prop="fmemberid">
				<el-input v-model="dataForm.fmemberid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="户口信息ID" prop="fresidentid">
				<el-input v-model="dataForm.fresidentid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="操作人员ID" prop="foperaerid">
				<el-input v-model="dataForm.foperaerid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="操作时间" prop="foperatime">
				<el-input v-model="dataForm.foperatime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="信息所属组织机构" prop="fownorganizationid">
				<el-input v-model="dataForm.fownorganizationid" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisible = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>

	<!--新增编辑界面  基本信息界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleBasic" :close-on-click-modal="false">
		<el-form :model="dataFormBasic" label-width="80px" :rules="dataFormRules" ref="dataFormBasic" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormBasicBasic.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工编码" prop="fworkercode" >
				<el-input v-model="dataFormBasic.fworkercode" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工姓名" prop="fworkername" >
				<el-input v-model="dataFormBasic.fworkername" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="头像" prop="fheadimage" >
				<el-input v-model="dataFormBasic.fheadimage" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="性别" prop="fgenderid" >
				<el-input v-model="dataFormBasic.fgenderid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="国籍" prop="fnationalityid" >
				<el-input v-model="dataFormBasic.fnationalityid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="民族" prop="fnationaid" >
				<el-input v-model="dataFormBasic.fnationaid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="政治面貌" prop="fpoliticstypeid" >
				<el-input v-model="dataFormBasic.fpoliticstypeid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证件类型" prop="fidcardtypeid" >
				<el-input v-model="dataFormBasic.fidcardtypeid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证件号码" prop="fidcardnumber" >
				<el-input v-model="dataFormBasic.fidcardnumber" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="毕业院校" prop="fgraduationschool" >
				<el-input v-model="dataFormBasic.fgraduationschool" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所属专业" prop="fmajor" >
				<el-input v-model="dataFormBasic.fmajor" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在省份" prop="fprovince" >
				<el-input v-model="dataFormBasic.fprovince" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在城市" prop="fcity" >
				<el-input v-model="dataFormBasic.fcity" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在县区" prop="fcountries" >
				<el-input v-model="dataFormBasic.fcountries" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在乡镇" prop="fvillage" >
				<el-input v-model="dataFormBasic.fvillage" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="户口所在地" prop="fbirthdayplace" >
				<el-input v-model="dataFormBasic.fbirthdayplace" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="行政级别" prop="fadministrativelevel" >
				<el-input v-model="dataFormBasic.fadministrativelevel" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="计算机水平" prop="fcomputerskill" >
				<el-input v-model="dataFormBasic.fcomputerskill" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="外语掌握程度" prop="fforeignlanguagelevel" >
				<el-input v-model="dataFormBasic.fforeignlanguagelevel" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="人才类型" prop="ftalenttype" >
				<el-input v-model="dataFormBasic.ftalenttype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证书等级" prop="fcertificationleveltype" >
				<el-input v-model="dataFormBasic.fcertificationleveltype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="最高证书等级" prop="fhighcerttificationleveltype" >
				<el-input v-model="dataFormBasic.fhighcerttificationleveltype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="健康状况" prop="fhealthid" >
				<el-input v-model="dataFormBasic.fhealthid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="婚姻状况" prop="fmaritalstatusid" >
				<el-input v-model="dataFormBasic.fmaritalstatusid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工状态" prop="fworkerstatusid" >
				<el-input v-model="dataFormBasic.fworkerstatusid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在部门" prop="fdepartmentid" >
				<el-input v-model="dataFormBasic.fdepartmentid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="工种" prop="fjobtypeid" >
				<el-input v-model="dataFormBasic.fjobtypeid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证书类型" prop="fcertificationnameid" >
				<el-input v-model="dataFormBasic.fcertificationnameid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="职务" prop="fdutyid" >
				<el-input v-model="dataFormBasic.fdutyid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="岗位类别" prop="fjobcategoryid" >
				<el-input v-model="dataFormBasic.fjobcategoryid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="作业人员身份" prop="foperationalidentityid" >
				<el-input v-model="dataFormBasic.foperationalidentityid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="作业单位" prop="fworkunitid" >
				<el-input v-model="dataFormBasic.fworkunitid" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="出生日期" prop="fbirthday" >
				<el-input v-model="dataFormBasic.fbirthday" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="年龄" prop="fage" >
				<el-input v-model="dataFormBasic.fage" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="入职时间" prop="fentrytime" >
				<el-input v-model="dataFormBasic.fentrytime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="转正日期" prop="fpositivitime" >
				<el-input v-model="dataFormBasic.fpositivitime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="毕业时间" prop="fgraduatationtime" >
				<el-input v-model="dataFormBasic.fgraduatationtime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社会工龄" prop="fsocialage" >
				<el-input v-model="dataFormBasic.fsocialage" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleBasic = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormBasic" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
  </div>
</template>





<script>
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import { format } from "@/utils/datetime"
export default {
	components:{
			KtTable,
			KtButton
	},
	data() {
		return {
			size: 'small',
			filters: {
				label: ''
			},
			columns: [
				{prop:"id", label:"ID", minWidth:100},
				{prop:"fbasicid", label:"人员基本信息ID", minWidth:100},
				{prop:"fcontactid", label:"联系信息ID", minWidth:100},
				{prop:"fsalaryid", label:"薪酬福利ID", minWidth:100},
				{prop:"fcontractid", label:"合同信息ID", minWidth:100},
				{prop:"fprotocolid", label:"协议ID", minWidth:100},
				{prop:"fexperienceid", label:"个人经历ID", minWidth:100},
				{prop:"fphysicalid", label:"体检信息ID", minWidth:100},
				{prop:"fmemberid", label:"家庭成员ID", minWidth:100},
				{prop:"fresidentid", label:"户口信息ID", minWidth:100},
				{prop:"foperaerid", label:"操作人员ID", minWidth:100},
				{prop:"foperatime", label:"操作时间", minWidth:100},
				{prop:"fownorganizationid", label:"信息所属组织机构", minWidth:100},
			],
			pageRequest: { pageNum: 1, pageSize: 8 },
			pageResult: {},

			operation: false, // true:新增, false:编辑
			editDialogVisible: false, // 新增编辑界面是否显示
			editDialogVisibleBasic: false, // 新增编辑界面是否显示
			editLoading: false,
			dataFormRules: {
				label: [
					{ required: true, message: '请输入名称', trigger: 'blur' }
				]
			},
			// 新增编辑界面数据
			dataForm: {
				id: null,
				fbasicid: null,
				fcontactid: null,
				fsalaryid: null,
				fcontractid: null,
				fprotocolid: null,
				fexperienceid: null,
				fphysicalid: null,
				fmemberid: null,
				fresidentid: null,
				foperaerid: null,
				foperatime: null,
				fownorganizationid: null,
			},
			// 新增编辑界面数据
			dataFormBasic: {
				id: null,
				fworkercode: null,
				fworkername: null,
				fheadimage: null,
				fgenderid: null,
				fnationalityid: null,
				fnationaid: null,
				fpoliticstypeid: null,
				fidcardtypeid: null,
				fidcardnumber: null,
				fgraduationschool: null,
				fmajor: null,
				fprovince: null,
				fcity: null,
				fcountries: null,
				fvillage: null,
				fbirthdayplace: null,
				fadministrativelevel: null,
				fcomputerskill: null,
				fforeignlanguagelevel: null,
				ftalenttype: null,
				fcertificationleveltype: null,
				fhighcerttificationleveltype: null,
				fhealthid: null,
				fmaritalstatusid: null,
				fworkerstatusid: null,
				fdepartmentid: null,
				fjobtypeid: null,
				fcertificationnameid: null,
				fdutyid: null,
				fjobcategoryid: null,
				foperationalidentityid: null,
				fworkunitid: null,
				fbirthday: null,
				fage: null,
				fentrytime: null,
				fpositivitime: null,
				fgraduatationtime: null,
				fsocialage: null,
			}
		}
	},
	methods: {
		// 获取分页数据
		findPage: function (data) {
			if(data !== null) {
				this.pageRequest = data.pageRequest
			}
			this.pageRequest.columnFilters = {label: {name:'label', value:this.filters.label}}
			this.$api.tbEmployee.findPage(this.pageRequest).then((res) => {
			this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.tbEmployee.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: 0,
				fbasicid: 1,
				fcontactid: 1,
				fsalaryid: 1,
				fcontractid: 1,
				fprotocolid: null,
				fexperienceid: null,
				fphysicalid: null,
				fmemberid: null,
				fresidentid: null,
				foperaerid: null,
				foperatime: null,
				fownorganizationid: null,
			}
		},// 显示新增界面
		handleAddBasic: function () {
			this.editDialogVisibleBasic = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormBasic = {
					id: 0,
					fworkercode: "0001",
					fworkername: "persea",
					fheadimage: null,
					fgenderid: 1,
					fnationalityid: 1,
					fnationaid: 1,
					fpoliticstypeid: 1,
					fidcardtypeid: 1,
					fidcardnumber: 1,
					fgraduationschool: 1,
					fmajor: 1,
					fprovince: 1,
					fcity: 1,
					fcountries: 1,
					fvillage: 1,
					fbirthdayplace: 1,
					fadministrativelevel: 1,
					fcomputerskill: 1,
					fforeignlanguagelevel: 1,
					ftalenttype: 1,
					fcertificationleveltype: 1,
					fhighcerttificationleveltype: 1,
					fhealthid: 1,
					fmaritalstatusid: 1,
					fworkerstatusid: 1,
					fdepartmentid: 1,
					fjobtypeid: 1,
					fcertificationnameid: 1,
					fdutyid: 1,
					fjobcategoryid: 1,
					foperationalidentityid: 1,
					fworkunitid: 1,
					fbirthday: "2017-12-04T18:07:57Z",
					fage: 1,
					fentrytime: "2017-12-04T18:07:57Z",
					fpositivitime: "2017-12-04T18:07:57Z",
					fgraduatationtime: "2017-12-04T18:07:57Z",
					fsocialage: 1,
				}
			}else{
				this.$api.tbEmployee.findById(this.dataForm.fbasicid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormBasic.fworkercode= res.data.fworkercode;
							this.dataFormBasic.fworkername = res.data.fworkername;
							this.dataFormBasic.fheadimage = res.data.fheadimage;
							this.dataFormBasic.fgenderid = res.data.fgenderid;
							this.dataFormBasic.fnationalityid = res.data.fnationalityid;
							this.dataFormBasic.fnationaid = res.data.fnationaid;
							this.dataFormBasic.fpoliticstypeid = res.data.fpoliticstypeid;
							this.dataFormBasic.fidcardtypeid = res.data.fidcardtypeid;
							this.dataFormBasic.fidcardnumber = res.data.fidcardnumber;
							this.dataFormBasic.fgraduationschool = res.data.fgraduationschool;
							this.dataFormBasic.fmajor = res.data.fmajor;
							this.dataFormBasic.fprovince = res.data.fprovince;
							this.dataFormBasic.fcity = res.data.fcity;
							this.dataFormBasic.fcountries = res.data.fcountries;
							this.dataFormBasic .fvillage= res.data.fvillage;
							this.dataFormBasic.fbirthdayplace = res.data.fbirthdayplace;
							this.dataFormBasic.fadministrativelevel = res.data.fadministrativelevel;
							this.dataFormBasic.fcomputerskill = res.data.fcomputerskill;
							this.dataFormBasic.fforeignlanguagelevel = res.data.fforeignlanguagelevel;
							this.dataFormBasic.ftalenttype = res.data.ftalenttype;
							this.dataFormBasic.fcertificationleveltype = res.data.fcertificationleveltype;
							this.dataFormBasic.fhighcerttificationleveltype = res.data.fhighcerttificationleveltype;
							this.dataFormBasic.fhealthid = res.data.fhealthid;
							this.dataFormBasic.fmaritalstatusid = res.data.fmaritalstatusid;
							this.dataFormBasic.fworkerstatusid = res.data.fworkerstatusid;
							this.dataFormBasic.fdepartmentid = res.data.fdepartmentid;
							this.dataFormBasic.fjobtypeid = res.data.fjobtypeid;
							this.dataFormBasic.fcertificationnameid = res.data.fcertificationnameid;
							this.dataFormBasic.fdutyid = res.data.fdutyid;
							this.dataFormBasic.fjobcategoryid = res.data.fjobcategoryid;
							this.dataFormBasic.foperationalidentityid = res.data.foperationalidentityid;
							this.dataFormBasic.fworkunitid = res.data.fworkunitid;
							this.dataFormBasic.fbirthday = res.data.fbirthday;
							this.dataFormBasic.fage = res.data.fage;
							this.dataFormBasic.fentrytime = res.data.fentrytime;
							this.dataFormBasic.fpositivitime = res.data.fpositivitime;
							this.dataFormBasic.fgraduatationtime = res.data.fgraduatationtime;
							this.dataFormBasic.fsocialage = res.data.fsocialage;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},
		// 显示编辑界面 主界面
		handleEdit: function (params) {
			this.editDialogVisible = true
			this.operation = false
			this.dataForm = Object.assign({}, params.row)
		},
		// 显示编辑界面 人员信息界面
		handleEditBasic: function (params) {
			this.editDialogVisibleBasic = true
			this.operation = false
			this.dataFormBasic = Object.assign({}, params.row)
		},
		// 编辑
		submitForm: function () {
			this.$refs.dataForm.validate((valid) => {
				if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
						let params = Object.assign({}, this.dataForm)
						this.$api.tbEmployee.save(params).then((res) => {
							if(res.code == 200) {
								this.$message({ message: '操作成功', type: 'success' })
							} else {
								this.$message({message: '操作失败, ' + res.msg, type: 'error'})
							}
							this.editLoading = false
							this.$refs['dataForm'].resetFields()
							this.editDialogVisible = false
							this.findPage(null)
						})
					})
				}
			})
		},// 编辑
		submitFormBasic: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormBasic)
							this.$api.tbEmployeeBasic.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.fbasicid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormBasic'].resetFields()
								this.editDialogVisibleBasic = false
								this.findPage(null)
							})
						})
					}
				})
			}else{
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormBasic)
							params.id = this.dataForm.fbasicid
							this.$api.tbEmployeeBasic.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.fbasicid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormBasic'].resetFields()
								this.editDialogVisibleBasic = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},
		// 时间格式化
      	dateFormat: function (row, column, cellValue, index){
          	return format(row[column.property])
      	}
	},
	mounted() {
	}
}
</script>

<style scoped>

</style>