<template>
  <div class="container" >
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:staffPayroll:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:staffPayroll:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:staffPayroll:edit" permsDelete="sys:staffPayroll:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="医疗保障号" prop="medicalsecuritynum"  >
				<el-input v-model="dataForm.medicalsecuritynum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社会保障号" prop="socialsecuritynum"  >
				<el-input v-model="dataForm.socialsecuritynum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="公积金账号" prop="accumulationfundaccount"  >
				<el-input v-model="dataForm.accumulationfundaccount" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社保组织关系" prop="socialsecurityorganizationrelationship"  >
				<el-input v-model="dataForm.socialsecurityorganizationrelationship" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社保档级" prop="socialsecuritylevel"  >
				<el-input v-model="dataForm.socialsecuritylevel" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="发薪方式" prop="paymenttype"  >
				<el-input v-model="dataForm.paymenttype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="银行账号" prop="bankaccount"  >
				<el-input v-model="dataForm.bankaccount" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="薪资地区" prop="salaryregion"  >
				<el-input v-model="dataForm.salaryregion" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社保开始缴纳时间" prop="socialsecuritystartstime"  >
				<el-input v-model="dataForm.socialsecuritystartstime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="公积金开始缴纳时间" prop="reservebeginstime"  >
				<el-input v-model="dataForm.reservebeginstime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社保缴纳基数" prop="socialsecuritypaymentbase"  >
				<el-input v-model="dataForm.socialsecuritypaymentbase" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="公积金缴纳基数" prop="reservepaymentbase"  >
				<el-input v-model="dataForm.reservepaymentbase" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="年金缴纳基数" prop="annuitypaymentbase"  >
				<el-input v-model="dataForm.annuitypaymentbase" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="发薪币种" prop="paycurrency"  >
				<el-input v-model="dataForm.paycurrency" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="发薪银行" prop="paybank"  >
				<el-input v-model="dataForm.paybank" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataForm.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataForm.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataForm.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
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
				{prop:"medicalsecuritynum", label:"医疗保障号", minWidth:100},
				{prop:"socialsecuritynum", label:"社会保障号", minWidth:100},
				{prop:"accumulationfundaccount", label:"公积金账号", minWidth:100},
				{prop:"socialsecurityorganizationrelationship", label:"社保组织关系", minWidth:100},
				{prop:"socialsecuritylevel", label:"社保档级", minWidth:100},
				{prop:"paymenttype", label:"发薪方式", minWidth:100},
				{prop:"bankaccount", label:"银行账号", minWidth:100},
				{prop:"salaryregion", label:"薪资地区", minWidth:100},
				{prop:"socialsecuritystartstime", label:"社保开始缴纳时间", minWidth:100},
				{prop:"reservebeginstime", label:"公积金开始缴纳时间", minWidth:100},
				{prop:"socialsecuritypaymentbase", label:"社保缴纳基数", minWidth:100},
				{prop:"reservepaymentbase", label:"公积金缴纳基数", minWidth:100},
				{prop:"annuitypaymentbase", label:"年金缴纳基数", minWidth:100},
				{prop:"paycurrency", label:"发薪币种", minWidth:100},
				{prop:"paybank", label:"发薪银行", minWidth:100},
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
				medicalsecuritynum: null,
				socialsecuritynum: null,
				accumulationfundaccount: null,
				socialsecurityorganizationrelationship: null,
				socialsecuritylevel: null,
				paymenttype: null,
				bankaccount: null,
				salaryregion: null,
				socialsecuritystartstime: null,
				reservebeginstime: null,
				socialsecuritypaymentbase: null,
				reservepaymentbase: null,
				annuitypaymentbase: null,
				paycurrency: null,
				paybank: null,
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
			this.$api.staffPayroll.findPage(this.pageRequest).then((res) => {
				this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.staffPayroll.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: 0,
				medicalsecuritynum: null,
				socialsecuritynum: null,
				accumulationfundaccount: null,
				socialsecurityorganizationrelationship: null,
				socialsecuritylevel: null,
				paymenttype: null,
				bankaccount: null,
				salaryregion: null,
				socialsecuritystartstime: null,
				reservebeginstime: null,
				socialsecuritypaymentbase: null,
				reservepaymentbase: null,
				annuitypaymentbase: null,
				paycurrency: null,
				paybank: null,
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
						this.$api.staffPayroll.save(params).then((res) => {
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