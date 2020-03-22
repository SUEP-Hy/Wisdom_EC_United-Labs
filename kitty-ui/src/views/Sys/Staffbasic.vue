<template>
  <div class="container" >
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:staffBasic:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:staffBasic:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:staffBasic:edit" permsDelete="sys:staffBasic:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工编码" prop="code" >
				<el-input v-model="dataForm.code" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工姓名" prop="name" >
				<el-input v-model="dataForm.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="照片" prop="photo" >
				<el-input v-model="dataForm.photo" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="性别" prop="gender" >
				<el-input v-model="dataForm.gender" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="国籍" prop="nationality" >
				<el-input v-model="dataForm.nationality" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="民族" prop="nation" >
				<el-input v-model="dataForm.nation" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="政治面貌" prop="politicstype" >
				<el-input v-model="dataForm.politicstype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证件类型" prop="idcardtype" >
				<el-input v-model="dataForm.idcardtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证件号码" prop="idcardnum" >
				<el-input v-model="dataForm.idcardnum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="毕业院校" prop="graduationschool" >
				<el-input v-model="dataForm.graduationschool" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="毕业院校" prop="highesteducation" >
				<el-input v-model="dataForm.highesteducation" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所属专业" prop="major" >
				<el-input v-model="dataForm.major" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在省份" prop="province" >
				<el-input v-model="dataForm.province" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在城市" prop="city" >
				<el-input v-model="dataForm.city" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在县区" prop="country" >
				<el-input v-model="dataForm.country" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在乡镇" prop="village" >
				<el-input v-model="dataForm.village" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证书等级" prop="certificationlevel" >
				<el-input v-model="dataForm.certificationlevel" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="健康状况" prop="health" >
				<el-input v-model="dataForm.health" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="婚姻状况" prop="maritalstatus" >
				<el-input v-model="dataForm.maritalstatus" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工状态" prop="workerstatus" >
				<el-input v-model="dataForm.workerstatus" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在部门" prop="dept" >
				<el-input v-model="dataForm.dept" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="工种" prop="jobtype" >
				<el-input v-model="dataForm.jobtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证书类型" prop="certificationtype" >
				<el-input v-model="dataForm.certificationtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="职务" prop="position" >
				<el-input v-model="dataForm.position" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="岗位类别" prop="jobcategory" >
				<el-input v-model="dataForm.jobcategory" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工类别" prop="worktype" >
				<el-input v-model="dataForm.worktype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="作业单位" prop="workunit" >
				<el-input v-model="dataForm.workunit" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="出生日期" prop="birthday" >
				<el-input v-model="dataForm.birthday" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="年龄" prop="age" >
				<el-input v-model="dataForm.age" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="入职时间" prop="entry" >
				<el-input v-model="dataForm.entry" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="转正日期" prop="regularization" >
				<el-input v-model="dataForm.regularization" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="毕业时间" prop="graduatation" >
				<el-input v-model="dataForm.graduatation" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社会工龄" prop="socialage" >
				<el-input v-model="dataForm.socialage" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy" >
				<el-input v-model="dataForm.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime" >
				<el-input v-model="dataForm.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy" >
				<el-input v-model="dataForm.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime" >
				<el-input v-model="dataForm.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisible = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
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
				{prop:"code", label:"员工编码", minWidth:100},
				{prop:"name", label:"员工姓名", minWidth:100},
				{prop:"photo", label:"照片", minWidth:100},
				{prop:"gender", label:"性别", minWidth:100},
				{prop:"nationality", label:"国籍", minWidth:100},
				{prop:"nation", label:"民族", minWidth:100},
				{prop:"politicstype", label:"政治面貌", minWidth:100},
				{prop:"idcardtype", label:"证件类型", minWidth:100},
				{prop:"idcardnum", label:"证件号码", minWidth:100},
				{prop:"graduationschool", label:"毕业院校", minWidth:100},
				{prop:"highesteducation", label:"毕业院校", minWidth:100},
				{prop:"major", label:"所属专业", minWidth:100},
				{prop:"province", label:"所在省份", minWidth:100},
				{prop:"city", label:"所在城市", minWidth:100},
				{prop:"country", label:"所在县区", minWidth:100},
				{prop:"village", label:"所在乡镇", minWidth:100},
				{prop:"certificationlevel", label:"证书等级", minWidth:100},
				{prop:"health", label:"健康状况", minWidth:100},
				{prop:"maritalstatus", label:"婚姻状况", minWidth:100},
				{prop:"workerstatus", label:"员工状态", minWidth:100},
				{prop:"dept", label:"所在部门", minWidth:100},
				{prop:"jobtype", label:"工种", minWidth:100},
				{prop:"certificationtype", label:"证书类型", minWidth:100},
				{prop:"position", label:"职务", minWidth:100},
				{prop:"jobcategory", label:"岗位类别", minWidth:100},
				{prop:"worktype", label:"员工类别", minWidth:100},
				{prop:"workunit", label:"作业单位", minWidth:100},
				{prop:"birthday", label:"出生日期", minWidth:100},
				{prop:"age", label:"年龄", minWidth:100},
				{prop:"entry", label:"入职时间", minWidth:100},
				{prop:"regularization", label:"转正日期", minWidth:100},
				{prop:"graduatation", label:"毕业时间", minWidth:100},
				{prop:"socialage", label:"社会工龄", minWidth:100},
				{prop:"createBy", label:"创建人", minWidth:100},
				{prop:"createTime", label:"创建时间", minWidth:100},
				{prop:"lastUpdateBy", label:"更新人", minWidth:100},
				{prop:"lastUpdateTime", label:"更新时间", minWidth:100},
			],
			pageRequest: { pageNum: 1, pageSize: 8 },
			pageResult: {},

			operation: false, // true:新增, false:编辑
			editDialogVisible: false, // 新增编辑界面是否显示
			editLoading: false,
			dataFormRules: {
				label: [
					{ required: true, message: '请输入名称', trigger: 'blur' }
				]
			},
			// 新增编辑界面数据
			dataForm: {
				id: null,
				code: null,
				name: null,
				photo: null,
				gender: null,
				nationality: null,
				nation: null,
				politicstype: null,
				idcardtype: null,
				idcardnum: null,
				graduationschool: null,
				highesteducation: null,
				major: null,
				province: null,
				city: null,
				country: null,
				village: null,
				certificationlevel: null,
				health: null,
				maritalstatus: null,
				workerstatus: null,
				dept: null,
				jobtype: null,
				certificationtype: null,
				position: null,
				jobcategory: null,
				worktype: null,
				workunit: null,
				birthday: null,
				age: null,
				entry: null,
				regularization: null,
				graduatation: null,
				socialage: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
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
			this.$api.staffBasic.findPage(this.pageRequest).then((res) => {
				this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.staffBasic.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: 0,
				code: null,
				name: null,
				photo: null,
				gender: null,
				nationality: null,
				nation: null,
				politicstype: null,
				idcardtype: null,
				idcardnum: null,
				graduationschool: null,
				highesteducation: null,
				major: null,
				province: null,
				city: null,
				country: null,
				village: null,
				certificationlevel: null,
				health: null,
				maritalstatus: null,
				workerstatus: null,
				dept: null,
				jobtype: null,
				certificationtype: null,
				position: null,
				jobcategory: null,
				worktype: null,
				workunit: null,
				birthday: null,
				age: null,
				entry: null,
				regularization: null,
				graduatation: null,
				socialage: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			}
		},
		// 显示编辑界面
		handleEdit: function (params) {
			this.editDialogVisible = true
			this.operation = false
			this.dataForm = Object.assign({}, params.row)
		},
		// 编辑
		submitForm: function () {
			this.$refs.dataForm.validate((valid) => {
				if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
						let params = Object.assign({}, this.dataForm)
						this.$api.staffBasic.save(params).then((res) => {
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