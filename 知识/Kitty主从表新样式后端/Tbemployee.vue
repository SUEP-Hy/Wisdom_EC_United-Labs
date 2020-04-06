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
	<el-dialog :title="operation?'新增':'编辑'" width="70%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="人员基本信息ID" prop="fbasicid" v-if="false">
				<el-input v-model="dataForm.fbasicid" auto-complete="off" v-if="false"></el-input>
				<kt-button label="人员基本信息"  perms="sys:tbEmployeeBasic:view" @click="handleAddBasic" v-if="false"></kt-button>
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
				 <el-date-picker
					v-model="dataForm.foperatime"
					type="datetime"
					:default-time = "['0000:00:00','23:59:59']"
					value-format="yyyy-MM-dd HH:mm:ss"
					 auto-complete="off">
    			</el-date-picker>
				<!-- <el-input v-model="dataForm.foperatime" auto-complete="off"></el-input> -->
			</el-form-item>
			<el-form-item label="信息所属组织机构" prop="fownorganizationid">
				<el-input v-model="dataForm.fownorganizationid" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>

		  <div>
			<el-tabs v-model="activeName" type="card">
				<el-tab-pane label="人员基本信息" name="first">
         		<tbEmployeeBasic :msg1="basicload" :msg2="basicid" :key="basickey" @basicparams="onbasicparams"></tbEmployeeBasic>
				</el-tab-pane>
			</el-tabs>
		  </div>

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
import { formatout } from "@/utils/datetime"
import tbEmployeeBasic from "@/views/Sys/Tbemployeebasic"
export default {
	components:{
			KtTable,
			KtButton,
			tbEmployeeBasic
	},
	props: {
		panes: {
			type: Array,
			default: () => ([])
		},
		height: {
			type: Number,
			default: 300
		},
		show: {
			type: Boolean,
			default: false
		}
   },
	data() {
		return {
			activeName: 'basic',
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
			operation: false, //主表 true:新增, false:编辑
			
			basicload:0, //子表获取主表操作
			basickey: 0, // 子表标志，用于页面刷新消息通知
			basicid: 0, // 主表中子表id值默认为0
			basicparams: 0, //主表接受子表的数据
			
			editDialogVisible: false, // 新增编辑界面是否显示
			editDialogVisibleBasic: false, // 新增编辑界面是否显示  人员基本信息
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
			}
		}
	},
	methods: {
		//获取basic子类提交信息
		onbasicparams: function(ev){
			this.basicparams = ev;
		},
		// 获取分页数据
		findPage: function (data) {
			if(data !== null) {
				this.pageRequest = data.pageRequest
			}
			this.pageRequest.columnFilters = {label: {name:'label', value:this.filters.label}}
			this.$api.tbEmployee.findPage(this.pageRequest).then((res) => {
				for(var i=0;i<res.data.totalSize;i++){
					res.data.content[i].foperatime = format(res.data.content[i].foperatime);
				}
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

			this.basicload = 1
			this.basickey++

			this.style=""
			this.dataForm = {
				id: 0,
				fbasicid: 1,
				fcontactid: 1,
				fsalaryid: 1,
				fcontractid: 1,
				fprotocolid: 1,
				fexperienceid: 1,
				fphysicalid: 1,
				fmemberid: 1,
				fresidentid: 1,
				foperaerid: 1,
				foperatime: "2017-12-04T18:07:57Z",
				fownorganizationid: 1,
			}
		},
		// 显示编辑界面 主界面
		handleEdit: function (params) {
			this.basicid = params.row.fbasicid
			this.editDialogVisible = true
			this.operation = false

			this.basicload = 2
			this.basickey++

			this.dataForm = Object.assign({}, params.row)
		},
		// 编辑 主界面
		submitForm: function () {
			this.$refs.dataForm.validate((valid) => {
				if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
						let params = Object.assign({}, this.dataForm)

						//基本信息子表提交后台处理
						this.basicparams.fbirthday =  formatout(this.basicparams.fbirthday)
						this.basicparams.fentrytime =  formatout(this.basicparams.fentrytime)
						this.basicparams.fpositivitime =  formatout(this.basicparams.fpositivitime)
						this.basicparams.fgraduatationtime =  formatout(this.basicparams.fgraduatationtime)    //格式转换

						params.foperatime =  formatout(params.foperatime)   //格式转换
						var a = {"main": params,"basic": this.basicparams}  //定义json数据存储主从表数据
						this.$api.tbEmployee.save(a).then((res) => {
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

						// this.$api.tbEmployeeBasic.save(this.basicparams).then((res) => {
						// 	if(res.code == 200) {
						// 		params.fbasicid = res.data;
						// 		this.$message({ message: '操作成功', type: 'success' })
						// 	} else {
						// 		this.$message({message: '操作失败, ' + res.msg, type: 'error'})
						// 	}
						// })

						// //主表操作设置timeout等待其他子表处理完返回子表id值到主表
						// setTimeout(() =>{
						// 	//主表信息提交后台处理
						// 	params.foperatime =  formatout(params.foperatime)   //格式转换
						// 	this.$api.tbEmployee.save(params).then((res) => {
						// 		if(res.code == 200) {
						// 			this.$message({ message: '操作成功', type: 'success' })
						// 		} else {
						// 			this.$message({message: '操作失败, ' + res.msg, type: 'error'})
						// 		}
						// 		this.editLoading = false
						// 		this.$refs['dataForm'].resetFields()
						// 		this.editDialogVisible = false
						// 		this.findPage(null)
						// 	})
						// },1000);

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
