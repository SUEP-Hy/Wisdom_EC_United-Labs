<template>
  <div class="container" >
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:staffContact:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:staffContact:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:staffContact:edit" permsDelete="sys:staffContact:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="联系手机" prop="cellphone" >
				<el-input v-model="dataForm.cellphone" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="电子邮箱" prop="email"  >
				<el-input v-model="dataForm.email" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="微信号" prop="wechatnum"  >
				<el-input v-model="dataForm.wechatnum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="办公电话" prop="officephone"  >
				<el-input v-model="dataForm.officephone" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="企业短号" prop="enterprisecornet"  >
				<el-input v-model="dataForm.enterprisecornet" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="籍贯" prop="nativeplace"  >
				<el-input v-model="dataForm.nativeplace" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="现居住地" prop="currentaddr"  >
				<el-input v-model="dataForm.currentaddr" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="邮编" prop="zipcode"  >
				<el-input v-model="dataForm.zipcode" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="紧急联系人" prop="urgentcontact"  >
				<el-input v-model="dataForm.urgentcontact" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="与本人关系" prop="relationship"  >
				<el-input v-model="dataForm.relationship" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="联系人电话" prop="contactphone"  >
				<el-input v-model="dataForm.contactphone" auto-complete="off"></el-input>
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
				{prop:"cellphone", label:"联系手机", minWidth:100},
				{prop:"email", label:"电子邮箱", minWidth:100},
				{prop:"wechatnum", label:"微信号", minWidth:100},
				{prop:"officephone", label:"办公电话", minWidth:100},
				{prop:"enterprisecornet", label:"企业短号", minWidth:100},
				{prop:"nativeplace", label:"籍贯", minWidth:100},
				{prop:"currentaddr", label:"现居住地", minWidth:100},
				{prop:"zipcode", label:"邮编", minWidth:100},
				{prop:"urgentcontact", label:"紧急联系人", minWidth:100},
				{prop:"relationship", label:"与本人关系", minWidth:100},
				{prop:"contactphone", label:"联系人电话", minWidth:100},
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
				cellphone: null,
				email: null,
				wechatnum: null,
				officephone: null,
				enterprisecornet: null,
				nativeplace: null,
				currentaddr: null,
				zipcode: null,
				urgentcontact: null,
				relationship: null,
				contactphone: null,
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
			this.$api.staffContact.findPage(this.pageRequest).then((res) => {
				this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.staffContact.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: 0,
				cellphone: null,
				email: null,
				wechatnum: null,
				officephone: null,
				enterprisecornet: null,
				nativeplace: null,
				currentaddr: null,
				zipcode: null,
				urgentcontact: null,
				relationship: null,
				contactphone: null,
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
						this.$api.staffContact.save(params).then((res) => {
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