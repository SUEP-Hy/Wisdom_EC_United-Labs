<template>
  <div class="container" >
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:staffProtocol:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:staffProtocol:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:staffProtocol:edit" permsDelete="sys:staffProtocol:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议类型" prop="type"  >
				<el-input v-model="dataForm.type" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议名称" prop="name"  >
				<el-input v-model="dataForm.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="签订方式" prop="signtype"  >
				<el-input v-model="dataForm.signtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="甲方" prop="firstparty"  >
				<el-input v-model="dataForm.firstparty" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="附件" prop="paccessory"  >
				<el-input v-model="dataForm.paccessory" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议编码" prop="code"  >
				<el-input v-model="dataForm.code" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="签订日期" prop="signdate"  >
				<el-input v-model="dataForm.signdate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议期限" prop="deadline"  >
				<el-input v-model="dataForm.deadline" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="开始时间" prop="pstartdate"  >
				<el-input v-model="dataForm.pstartdate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="结束时间" prop="penddate"  >
				<el-input v-model="dataForm.penddate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="终止日期" prop="terminaldate"  >
				<el-input v-model="dataForm.terminaldate" auto-complete="off"></el-input>
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
				{prop:"type", label:"协议类型", minWidth:100},
				{prop:"name", label:"协议名称", minWidth:100},
				{prop:"signtype", label:"签订方式", minWidth:100},
				{prop:"firstparty", label:"甲方", minWidth:100},
				{prop:"paccessory", label:"附件", minWidth:100},
				{prop:"code", label:"协议编码", minWidth:100},
				{prop:"signdate", label:"签订日期", minWidth:100},
				{prop:"deadline", label:"协议期限", minWidth:100},
				{prop:"pstartdate", label:"开始时间", minWidth:100},
				{prop:"penddate", label:"结束时间", minWidth:100},
				{prop:"terminaldate", label:"终止日期", minWidth:100},
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
				type: null,
				name: null,
				signtype: null,
				firstparty: null,
				paccessory: null,
				code: null,
				signdate: null,
				deadline: null,
				pstartdate: null,
				penddate: null,
				terminaldate: null,
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
			this.$api.staffProtocol.findPage(this.pageRequest).then((res) => {
				this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.staffProtocol.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: 0,
				type: null,
				name: null,
				signtype: null,
				firstparty: null,
				paccessory: null,
				code: null,
				signdate: null,
				deadline: null,
				pstartdate: null,
				penddate: null,
				terminaldate: null,
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
						this.$api.staffProtocol.save(params).then((res) => {
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