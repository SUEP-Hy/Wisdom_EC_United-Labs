<template>
  <div class="container" >
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:staffSummary:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:staffSummary:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:staffSummary:edit" permsDelete="sys:staffSummary:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面  主页面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="基本信息" prop="basicid"  >
				<el-input v-model="dataForm.basicid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="基本信息"  perms="sys:staffBasic:view" @click="handleAddBasic"></kt-button>
			</el-form-item>
			<el-form-item label="联系信息" prop="contactid"  >
				<el-input v-model="dataForm.contactid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="联系信息"  perms="sys:staffContact:view" @click="handleAddContact"></kt-button>
			</el-form-item>
			<el-form-item label="薪酬福利" prop="payrollid"  >
				<el-input v-model="dataForm.payrollid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="薪酬福利"  perms="sys:staffPayroll:view" @click="handleAddPayroll"></kt-button>
			</el-form-item>
			<el-form-item label="合同信息" prop="pactid"  >
				<el-input v-model="dataForm.pactid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="合同信息"  perms="sys:staffPact:view" @click="handleAddPact"></kt-button>
			</el-form-item>
			<el-form-item label="协议信息" prop="protocolid"  >
				<el-input v-model="dataForm.protocolid" auto-complete="off"   v-if="false" ></el-input>
			<kt-button label="协议信息"  perms="sys:staffProtocol:view" @click="handleAddProtocol"></kt-button>			
			</el-form-item>
			<el-form-item label="变动经历" prop="experienceid"  >
				<el-input v-model="dataForm.experienceid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="变动经历"  perms="sys:staffExperience:view" @click="handleAddExperience"></kt-button>
			</el-form-item>
			<el-form-item label="体检信息" prop="physicalid"  >
				<el-input v-model="dataForm.physicalid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="体检信息"  perms="sys:staffPhysical:view" @click="handleAddPhysical"></kt-button>
			</el-form-item>
			<el-form-item label="家庭信息" prop="familyid"  >
				<el-input v-model="dataForm.familyid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="家庭信息"  perms="sys:staffFamily:view" @click="handleAddFamily"></kt-button>
			</el-form-item>
			<el-form-item label="户口信息" prop="residentid"  >
				<el-input v-model="dataForm.residentid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="户口信息"  perms="sys:staffResident:view" @click="handleAddResident"></kt-button>
			</el-form-item>
			<el-form-item label="培训信息" prop="trainid"  >
				<el-input v-model="dataForm.trainid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="培训信息"  perms="sys:staffTrain:view" @click="handleAddTrain"></kt-button>
			</el-form-item>
			<el-form-item label="进出场记录" prop="inoutid"  >
				<el-input v-model="dataForm.inoutid" auto-complete="off"  v-if="false" ></el-input>
			<kt-button label="进出场记录"  perms="sys:staffInout:view" @click="handleAddInout"></kt-button>	
			</el-form-item>
			<el-form-item label="生物特征" prop="biofeatureid"  >
				<el-input v-model="dataForm.biofeatureid" auto-complete="off"  v-if="false" ></el-input>
				<kt-button label="生物特征"  perms="sys:staffBiofeature:view" @click="handleAddBiofeature"></kt-button>
			</el-form-item>
			<el-form-item label="字典" prop="dictionaryid"   v-if="false"  >
				<el-input v-model="dataForm.dictionaryid" auto-complete="off"   v-if="false" ></el-input>
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
	<!--新增编辑界面   进出场记录-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleInout" :close-on-click-modal="false">
		<el-form :model="dataFormInout" label-width="80px" :rules="dataFormRules" ref="dataFormInout" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormInout.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="考勤时间" prop="attendancetime" >
				<el-input v-model="dataFormInout.attendancetime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="考勤方向" prop="attendancedirection" >
				<el-input v-model="dataFormInout.attendancedirection" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="考勤设备" prop="device" >
				<el-input v-model="dataFormInout.device" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="考勤地点" prop="site" >
				<el-input v-model="dataFormInout.site" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy" >
				<el-input v-model="dataFormInout.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime" >
				<el-input v-model="dataFormInout.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy" >
				<el-input v-model="dataFormInout.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime" >
				<el-input v-model="dataFormInout.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleInout = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormInout" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
	<!--新增编辑界面  协议信息-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleProtocol" :close-on-click-modal="false">
		<el-form :model="dataFormProtocol" label-width="80px" :rules="dataFormRules" ref="dataFormProtocol" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormProtocol.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议类型" prop="type"  >
				<el-input v-model="dataFormProtocol.type" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议名称" prop="name"  >
				<el-input v-model="dataFormProtocol.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="签订方式" prop="signtype"  >
				<el-input v-model="dataFormProtocol.signtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="甲方" prop="firstparty"  >
				<el-input v-model="dataFormProtocol.firstparty" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="附件" prop="paccessory"  >
				<el-input v-model="dataFormProtocol.paccessory" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议编码" prop="code"  >
				<el-input v-model="dataFormProtocol.code" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="签订日期" prop="signdate"  >
				<el-input v-model="dataFormProtocol.signdate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="协议期限" prop="deadline"  >
				<el-input v-model="dataFormProtocol.deadline" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="开始时间" prop="pstartdate"  >
				<el-input v-model="dataFormProtocol.pstartdate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="结束时间" prop="penddate"  >
				<el-input v-model="dataFormProtocol.penddate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="终止日期" prop="terminaldate"  >
				<el-input v-model="dataFormProtocol.terminaldate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormProtocol.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormProtocol.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormProtocol.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormProtocol.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleProtocol = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormProtocol" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>	
	<!--新增编辑界面   基本信息-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleBasic" :close-on-click-modal="false">
		<el-form :model="dataFormBasic" label-width="80px" :rules="dataFormRules" ref="dataFormBasic" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormBasic.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工编码" prop="code" >
				<el-input v-model="dataFormBasic.code" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工姓名" prop="name" >
				<el-input v-model="dataFormBasic.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="照片" prop="photo" >
				<el-input v-model="dataFormBasic.photo" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="性别" prop="gender" >
				<el-input v-model="dataFormBasic.gender" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="国籍" prop="nationality" >
				<el-input v-model="dataFormBasic.nationality" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="民族" prop="nation" >
				<el-input v-model="dataFormBasic.nation" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="政治面貌" prop="politicstype" >
				<el-input v-model="dataFormBasic.politicstype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证件类型" prop="idcardtype" >
				<el-input v-model="dataFormBasic.idcardtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证件号码" prop="idcardnum" >
				<el-input v-model="dataFormBasic.idcardnum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="毕业院校" prop="graduationschool" >
				<el-input v-model="dataFormBasic.graduationschool" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="毕业院校" prop="highesteducation" >
				<el-input v-model="dataFormBasic.highesteducation" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所属专业" prop="major" >
				<el-input v-model="dataFormBasic.major" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在省份" prop="province" >
				<el-input v-model="dataFormBasic.province" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在城市" prop="city" >
				<el-input v-model="dataFormBasic.city" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在县区" prop="country" >
				<el-input v-model="dataFormBasic.country" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在乡镇" prop="village" >
				<el-input v-model="dataFormBasic.village" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证书等级" prop="certificationlevel" >
				<el-input v-model="dataFormBasic.certificationlevel" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="健康状况" prop="health" >
				<el-input v-model="dataFormBasic.health" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="婚姻状况" prop="maritalstatus" >
				<el-input v-model="dataFormBasic.maritalstatus" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工状态" prop="workerstatus" >
				<el-input v-model="dataFormBasic.workerstatus" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所在部门" prop="dept" >
				<el-input v-model="dataFormBasic.dept" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="工种" prop="jobtype" >
				<el-input v-model="dataFormBasic.jobtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证书类型" prop="certificationtype" >
				<el-input v-model="dataFormBasic.certificationtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="职务" prop="position" >
				<el-input v-model="dataFormBasic.position" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="岗位类别" prop="jobcategory" >
				<el-input v-model="dataFormBasic.jobcategory" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="员工类别" prop="worktype" >
				<el-input v-model="dataFormBasic.worktype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="作业单位" prop="workunit" >
				<el-input v-model="dataFormBasic.workunit" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="出生日期" prop="birthday" >
				<el-input v-model="dataFormBasic.birthday" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="年龄" prop="age" >
				<el-input v-model="dataFormBasic.age" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="入职时间" prop="entry" >
				<el-input v-model="dataFormBasic.entry" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="转正日期" prop="regularization" >
				<el-input v-model="dataFormBasic.regularization" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="毕业时间" prop="graduatation" >
				<el-input v-model="dataFormBasic.graduatation" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社会工龄" prop="socialage" >
				<el-input v-model="dataFormBasic.socialage" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy" >
				<el-input v-model="dataFormBasic.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime" >
				<el-input v-model="dataFormBasic.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy" >
				<el-input v-model="dataFormBasic.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime" >
				<el-input v-model="dataFormBasic.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleBasic = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormBasic" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>	
	<!--新增编辑界面   联系信息-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleContact" :close-on-click-modal="false">
		<el-form :model="dataFormContact" label-width="80px" :rules="dataFormRules" ref="dataFormContact" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormContact.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="联系手机" prop="cellphone" >
				<el-input v-model="dataFormContact.cellphone" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="电子邮箱" prop="email"  >
				<el-input v-model="dataFormContact.email" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="微信号" prop="wechatnum"  >
				<el-input v-model="dataFormContact.wechatnum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="办公电话" prop="officephone"  >
				<el-input v-model="dataFormContact.officephone" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="企业短号" prop="enterprisecornet"  >
				<el-input v-model="dataFormContact.enterprisecornet" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="籍贯" prop="nativeplace"  >
				<el-input v-model="dataFormContact.nativeplace" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="现居住地" prop="currentaddr"  >
				<el-input v-model="dataFormContact.currentaddr" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="邮编" prop="zipcode"  >
				<el-input v-model="dataFormContact.zipcode" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="紧急联系人" prop="urgentcontact"  >
				<el-input v-model="dataFormContact.urgentcontact" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="与本人关系" prop="relationship"  >
				<el-input v-model="dataFormContact.relationship" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="联系人电话" prop="contactphone"  >
				<el-input v-model="dataFormContact.contactphone" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormContact.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormContact.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormContact.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormContact.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleContact = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormContact" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>	
	<!--新增编辑界面  生物特征-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleBiofeature" :close-on-click-modal="false">
		<el-form :model="dataFormBiofeature" label-width="80px" :rules="dataFormRules" ref="dataFormBiofeature" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormBiofeature.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="生物类型" prop="type"  >
				<el-input v-model="dataFormBiofeature.type" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="姓名" prop="name"  >
				<el-input v-model="dataFormBiofeature.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="编码" prop="code"  >
				<el-input v-model="dataFormBiofeature.code" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormBiofeature.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormBiofeature.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormBiofeature.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormBiofeature.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleBiofeature = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormBiofeature" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>	
	<!--新增编辑界面   变动经历-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleExperience" :close-on-click-modal="false">
		<el-form :model="dataFormExperience" label-width="80px" :rules="dataFormRules" ref="dataFormExperience" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormExperience.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="项目名称" prop="name"  >
				<el-input v-model="dataFormExperience.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="项目岗位" prop="post"  >
				<el-input v-model="dataFormExperience.post" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="项目类别" prop="type"  >
				<el-input v-model="dataFormExperience.type" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="项目描述" prop="describe"  >
				<el-input v-model="dataFormExperience.describe" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="证明人" prop="witness"  >
				<el-input v-model="dataFormExperience.witness" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="开始时间" prop="pstartdate"  >
				<el-input v-model="dataFormExperience.pstartdate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="结束时间" prop="penddate"  >
				<el-input v-model="dataFormExperience.penddate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormExperience.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormExperience.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormExperience.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormExperience.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleExperience = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormExperience" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>	
	<!--新增编辑界面    家庭信息-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleFamily" :close-on-click-modal="false">
		<el-form :model="dataFormFamily" label-width="80px" :rules="dataFormRules" ref="dataFormFamily" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormFamily.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="与本人关系" prop="relationship" >
				<el-input v-model="dataFormFamily.relationship" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="姓名" prop="name" >
				<el-input v-model="dataFormFamily.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="工作单位" prop="workunits" >
				<el-input v-model="dataFormFamily.workunits" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="岗位及职务" prop="postoffice" >
				<el-input v-model="dataFormFamily.postoffice" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="联系地址" prop="contactaddr" >
				<el-input v-model="dataFormFamily.contactaddr" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="联系电话" prop="contactnum" >
				<el-input v-model="dataFormFamily.contactnum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="联系邮箱" prop="contactemail" >
				<el-input v-model="dataFormFamily.contactemail" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="年龄" prop="age" >
				<el-input v-model="dataFormFamily.age" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="生日" prop="birthday" >
				<el-input v-model="dataFormFamily.birthday" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy" >
				<el-input v-model="dataFormFamily.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime" >
				<el-input v-model="dataFormFamily.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy" >
				<el-input v-model="dataFormFamily.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime" >
				<el-input v-model="dataFormFamily.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleFamily = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormFamily" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
	<!--新增编辑界面  合同信息-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisiblePact" :close-on-click-modal="false">
		<el-form :model="dataFormPact" label-width="80px" :rules="dataFormRules" ref="dataFormPact" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormPact.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="合同编号" prop="code"  >
				<el-input v-model="dataFormPact.code" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="签订方式" prop="signtype"  >
				<el-input v-model="dataFormPact.signtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="甲方" prop="firstparty"  >
				<el-input v-model="dataFormPact.firstparty" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="乙方" prop="secondparty"  >
				<el-input v-model="dataFormPact.secondparty" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="试用期限" prop="servicelife"  >
				<el-input v-model="dataFormPact.servicelife" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="工作城市" prop="workplace"  >
				<el-input v-model="dataFormPact.workplace" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="工作内容" prop="workduties"  >
				<el-input v-model="dataFormPact.workduties" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="派遣机构" prop="dispatchagency"  >
				<el-input v-model="dataFormPact.dispatchagency" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="签订日期" prop="signdate"  >
				<el-input v-model="dataFormPact.signdate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="试用开始日期" prop="pstartdate"  >
				<el-input v-model="dataFormPact.pstartdate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="试用结束日期" prop="penddate"  >
				<el-input v-model="dataFormPact.penddate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="转正日期" prop="regularizationdate"  >
				<el-input v-model="dataFormPact.regularizationdate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="合同类型" prop="type"  >
				<el-input v-model="dataFormPact.type" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="合同期限类型" prop="periodtype"  >
				<el-input v-model="dataFormPact.periodtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormPact.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormPact.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormPact.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormPact.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisiblePact= false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormPact" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
	<!--新增编辑界面   薪酬福利-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisiblePayroll" :close-on-click-modal="false">
		<el-form :model="dataFormPayroll" label-width="80px" :rules="dataFormRules" ref="dataFormPayroll" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormPayroll.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="医疗保障号" prop="medicalsecuritynum"  >
				<el-input v-model="dataFormPayroll.medicalsecuritynum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社会保障号" prop="socialsecuritynum"  >
				<el-input v-model="dataFormPayroll.socialsecuritynum" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="公积金账号" prop="accumulationfundaccount"  >
				<el-input v-model="dataFormPayroll.accumulationfundaccount" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社保组织关系" prop="socialsecurityorganizationrelationship"  >
				<el-input v-model="dataFormPayroll.socialsecurityorganizationrelationship" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社保档级" prop="socialsecuritylevel"  >
				<el-input v-model="dataFormPayroll.socialsecuritylevel" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="发薪方式" prop="paymenttype"  >
				<el-input v-model="dataFormPayroll.paymenttype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="银行账号" prop="bankaccount"  >
				<el-input v-model="dataFormPayroll.bankaccount" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="薪资地区" prop="salaryregion"  >
				<el-input v-model="dataFormPayroll.salaryregion" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社保开始缴纳时间" prop="socialsecuritystartstime"  >
				<el-input v-model="dataFormPayroll.socialsecuritystartstime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="公积金开始缴纳时间" prop="reservebeginstime"  >
				<el-input v-model="dataFormPayroll.reservebeginstime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="社保缴纳基数" prop="socialsecuritypaymentbase"  >
				<el-input v-model="dataFormPayroll.socialsecuritypaymentbase" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="公积金缴纳基数" prop="reservepaymentbase"  >
				<el-input v-model="dataFormPayroll.reservepaymentbase" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="年金缴纳基数" prop="annuitypaymentbase"  >
				<el-input v-model="dataFormPayroll.annuitypaymentbase" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="发薪币种" prop="paycurrency"  >
				<el-input v-model="dataFormPayroll.paycurrency" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="发薪银行" prop="paybank"  >
				<el-input v-model="dataFormPayroll.paybank" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormPayroll.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormPayroll.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormPayroll.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormPayroll.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisiblePact = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormPayroll" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
	<!--新增编辑界面  体检信息-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisiblePhysical" :close-on-click-modal="false">
		<el-form :model="dataFormPhysical" label-width="80px" :rules="dataFormRules" ref="dataFormPhysical" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormPhysical.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="色盲" prop="achromate"  >
				<el-input v-model="dataFormPhysical.achromate" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="血型" prop="bloodtype"  >
				<el-input v-model="dataFormPhysical.bloodtype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="体检医院" prop="hospital"  >
				<el-input v-model="dataFormPhysical.hospital" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="体检项目" prop="item"  >
				<el-input v-model="dataFormPhysical.item" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="体检结论" prop="conclusion"  >
				<el-input v-model="dataFormPhysical.conclusion" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="身高" prop="height"  >
				<el-input v-model="dataFormPhysical.height" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="体重" prop="weight"  >
				<el-input v-model="dataFormPhysical.weight" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="左眼视力" prop="eyesightl"  >
				<el-input v-model="dataFormPhysical.eyesightl" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="右眼视力" prop="eyesightr"  >
				<el-input v-model="dataFormPhysical.eyesightr" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormPhysical.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormPhysical.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormPhysical.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormPhysical.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisiblePhysical= false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormPhysical" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>	
	<!--新增编辑界面   户口信息-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleResident" :close-on-click-modal="false">
		<el-form :model="dataFormResident" label-width="80px" :rules="dataFormRules" ref="dataFormResident" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormResident.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="姓名" prop="name"  >
				<el-input v-model="dataFormResident.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="配偶姓名" prop="matename"  >
				<el-input v-model="dataFormResident.matename" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="配偶户型" prop="matehousetype"  >
				<el-input v-model="dataFormResident.matehousetype" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="子女姓名" prop="childrenname"  >
				<el-input v-model="dataFormResident.childrenname" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="家庭住址" prop="permanentresidence"  >
				<el-input v-model="dataFormResident.permanentresidence" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="迁入地" prop="immigrationaddr"  >
				<el-input v-model="dataFormResident.immigrationaddr" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="迁出地" prop="emigrationtaddr"  >
				<el-input v-model="dataFormResident.emigrationtaddr" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="现居住地" prop="currentaddr"  >
				<el-input v-model="dataFormResident.currentaddr" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="迁入时间" prop="immigrationtime"  >
				<el-input v-model="dataFormResident.immigrationtime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="迁出时间" prop="emigrationtime"  >
				<el-input v-model="dataFormResident.emigrationtime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormResident.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormResident.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormResident.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormResident.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleResiddent = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormResident" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
	<!--新增编辑界面  培训信息-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisibleTrain" :close-on-click-modal="false">
		<el-form :model="dataFormTrain" label-width="80px" :rules="dataFormRules" ref="dataFormTrain" :size="size">
			<el-form-item label="ID" prop="id"  v-if="false">
				<el-input v-model="dataFormTrain.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="培训开始时间" prop="starttime"  >
				<el-input v-model="dataFormTrain.starttime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="培训结束时间" prop="endtime"  >
				<el-input v-model="dataFormTrain.endtime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="培训类型" prop="type"  >
				<el-input v-model="dataFormTrain.type" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  >
				<el-input v-model="dataFormTrain.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  >
				<el-input v-model="dataFormTrain.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  >
				<el-input v-model="dataFormTrain.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  >
				<el-input v-model="dataFormTrain.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisibleTrain = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitFormTrain" :loading="editLoading">{{$t('action.submit')}}</el-button>
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
				{prop:"basicid", label:"基本信息", minWidth:100},
				{prop:"contactid", label:"联系信息", minWidth:100},
				{prop:"payrollid", label:"薪酬福利", minWidth:100},
				{prop:"pactid", label:"合同信息", minWidth:100},
				{prop:"protocolid", label:"协议信息", minWidth:100},
				{prop:"experienceid", label:"变动经历", minWidth:100},
				{prop:"physicalid", label:"体检信息", minWidth:100},
				{prop:"familyid", label:"家庭信息", minWidth:100},
				{prop:"residentid", label:"户口信息", minWidth:100},
				{prop:"trainid", label:"培训信息", minWidth:100},
				{prop:"inoutid", label:"进出场记录", minWidth:100},
				{prop:"biofeatureid", label:"生物特征", minWidth:100},
				{prop:"dictionaryid", label:"字典", minWidth:100},
				{prop:"createBy", label:"创建人", minWidth:100},
				{prop:"createTime", label:"创建时间", minWidth:100},
				{prop:"lastUpdateBy", label:"更新人", minWidth:100},
				{prop:"lastUpdateTime", label:"更新时间", minWidth:100},
			],
			pageRequest: { pageNum: 1, pageSize: 8 },
			pageResult: {},

			operation: false, // true:新增, false:编辑
			editDialogVisible: false, // 新增编辑界面是否显示   主界面
			editDialogVisibleInout: false, // 新增编辑界面是否显示  进出场记录
			editDialogVisibleProtocol: false, // 新增编辑界面是否显示  协议信息
			editDialogVisibleBasic: false, // 新增编辑界面是否显示  基本信息		
			editDialogVisibleBiofeature: false, // 新增编辑界面是否显示  生物特征
			editDialogVisibleContact: false, // 新增编辑界面是否显示  联系信息
			editDialogVisibleExperience: false, // 新增编辑界面是否显示  变动经历
			editDialogVisibleFamily: false, // 新增编辑界面是否显示  家庭信息
			editDialogVisiblePact: false, // 新增编辑界面是否显示  合同信息
			editDialogVisiblePayroll: false, // 新增编辑界面是否显示  薪酬福利
			editDialogVisiblePhysical: false, // 新增编辑界面是否显示  体检信息
			editDialogVisibleResident: false, // 新增编辑界面是否显示  户口信息
			editDialogVisibleTrain: false, // 新增编辑界面是否显示  培训信息
			editLoading: false,
			dataFormRules: {
				label: [
					{ required: true, message: '请输入名称', trigger: 'blur' }
				]
			},
			// 新增编辑界面数据  主界面
			dataForm: {
				id: null,
				basicid: null,
				contactid: null,
				payrollid: null,
				pactid: null,
				protocolid: null,
				experienceid: null,
				physicalid: null,
				familyid: null,
				residentid: null,
				trainid: null,
				inoutid: null,
				biofeatureid: null,
				dictionaryid: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据  进出场纪录
			dataFormInout: {
				id: null,
				attendancetime: null,
				attendancedirection: null,
				device: null,
				site: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据   基本信息
			dataFormBasic: {
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
			},
			// 新增编辑界面数据   生物特征
			dataFormBiofeature: {
				id: null,
				type: null,
				name: null,
				code: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据   联系信息
			dataFormContact: {
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
			},
			// 新增编辑界面数据    变动经历
			dataFormExperience: {
				id: null,
				name: null,
				post: null,
				type: null,
				describe: null,
				witness: null,
				pstartdate: null,
				penddate: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据   家庭信息
			dataFormFamily: {
				id: null,
				relationship: null,
				name: null,
				workunits: null,
				postoffice: null,
				contactaddr: null,
				contactnum: null,
				contactemail: null,
				age: null,
				birthday: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据   合同信息
			dataFormPact: {
				id: null,
				code: null,
				signtype: null,
				firstparty: null,
				secondparty: null,
				servicelife: null,
				workplace: null,
				workduties: null,
				dispatchagency: null,
				signdate: null,
				pstartdate: null,
				penddate: null,
				regularizationdate: null,
				type: null,
				periodtype: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据   薪酬福利
			dataFormPayroll: {
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
			},
			// 新增编辑界面数据   体检信息
			dataFormPhysical: {
				id: null,
				achromate: null,
				bloodtype: null,
				hospital: null,
				item: null,
				conclusion: null,
				height: null,
				weight: null,
				eyesightl: null,
				eyesightr: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据    户口信息
			dataFormResident: {
				id: null,
				name: null,
				matename: null,
				matehousetype: null,
				childrenname: null,
				permanentresidence: null,
				immigrationaddr: null,
				emigrationtaddr: null,
				currentaddr: null,
				immigrationtime: null,
				emigrationtime: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据   培训信息
			dataFormTrain: {
				id: null,
				starttime: null,
				endtime: null,
				type: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			},
			// 新增编辑界面数据   协议信息
			dataFormProtocol: {
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
			this.$api.staffSummary.findPage(this.pageRequest).then((res) => {
				this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.staffSummary.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面   主界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: 0,
				basicid: null,
				contactid: null,
				payrollid: null,
				pactid: null,
				protocolid: null,
				experienceid: null,
				physicalid: null,
				familyid: null,
				residentid: null,
				trainid: null,
				inoutid: null,
				biofeatureid: null,
				dictionaryid: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
			}
		},
// 显示新增界面   进出场纪录
		handleAddInout: function () {
			this.editDialogVisibleInout = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormInout = {
				id: 0,
				attendancetime: null,
				attendancedirection: null,
				device: null,
				site: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				}
			}else{
				this.$api.staffSummary.findById(this.dataForm.inoutid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormInout.attendancetime= res.data.attendancetime;
							this.dataFormInout.attendancedirection= res.data.attendancedirection;
							this.dataFormInout.device= res.data.device;
							this.dataFormInout.site= res.data.site;
							this.dataFormInout.createBy= res.data.createBy;
							this.dataFormInout.createTime= res.data.createTime;
							this.dataFormInout.lastUpdateBy= res.data.lastUpdateBy;
							this.dataFormInout.lastUpdateTime= res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},
// 显示新增界面   协议信息
		handleAddProtocol: function () {
			this.editDialogVisibleProtocol = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormProtocol = {
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
			}else{
				this.$api.staffSummary.findById(this.dataForm.inoutid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormProtocol.type=res.data.type;
							this.dataFormProtocol.name=res.data.name;
							this.dataFormProtocol.signtype=res.data.signtype;
							this.dataFormProtocol.firstparty=res.data.firstparty;
							this.dataFormProtocol.paccessory=res.data.paccessory;
							this.dataFormProtocol.code=res.data.code;
							this.dataFormProtocol.signdate=res.data.signdate;
							this.dataFormProtocol.deadline=res.data.deadline;
							this.dataFormProtocol.pstartdate=res.data.pstartdate;
							this.dataFormProtocol.penddate=res.data.penddate;
							this.dataFormProtocol.terminaldate=res.data.terminaldate;
							this.dataFormProtocol.createBy=res.data.createBy;
							this.dataFormProtocol.createTime=res.data.createTime;
							this.dataFormProtocol.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormProtocol.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   基本信息
		handleAddBasic: function () {
			this.editDialogVisibleBasic = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormBasic = {
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
			}else{
				this.$api.staffSummary.findById(this.dataForm.basicid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormBasic.code=res.data.code;
							this.dataFormBasic.name=res.data.name;
							this.dataFormBasic.photo=res.data.photo;
							this.dataFormBasic.gender=res.data.gender;
							this.dataFormBasic.nationality=res.data.nationality;
							this.dataFormBasic.nation=res.data.nation;
							this.dataFormBasic.politicstype=res.data.politicstype;
							this.dataFormBasic.idcardtype=res.data.idcardtype;
							this.dataFormBasic.idcardnum=res.data.idcardnum;
							this.dataFormBasic.graduationschool=res.data;
							this.dataFormBasic.highesteducation=res.data.highesteducation;
							this.dataFormBasic.major=res.data.major;
							this.dataFormBasic.province=res.data.province;
							this.dataFormBasic.city=res.data.city;
							this.dataFormBasic.country=res.data.country;
							this.dataFormBasic.village=res.data.village;
							this.dataFormBasic.certificationlevel=res.data.certificationlevel;
							this.dataFormBasic.health=res.data.health;
							this.dataFormBasic.maritalstatus=res.data.maritalstatus;
							this.dataFormBasic.workerstatus=res.data.workerstatus;
							this.dataFormBasic.dept=res.data.dept;
							this.dataFormBasic.jobtype=res.data.jobtype;
							this.dataFormBasic.certificationtype=res.data.certificationtype;
							this.dataFormBasic.position=res.data.position;
							this.dataFormBasic.jobcategory=res.data.jobcategory;
							this.dataFormBasic.worktype=res.data.worktype;
							this.dataFormBasic.workunit=res.data.workunit;
							this.dataFormBasic.birthday=res.data.birthday;
							this.dataFormBasic.age=res.data.age;
							this.dataFormBasic.entry=res.data.entry;
							this.dataFormBasic.regularization=res.data.regularization;
							this.dataFormBasic.graduatation=res.data.socialage;
							this.dataFormBasic.socialage=res.data.socialage;
							this.dataFormBasic.createBy=res.data.createBy;
							this.dataFormBasic.createTime=res.data.createTime;
							this.dataFormBasic.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormBasic.lastUpdateTime=res.data.lastUpdateTime;			
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   生物特征
		handleAddBiofeature: function () {
			this.editDialogVisibleBiofeature = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormBiofeature = {
				id: 0,
				type: null,
				name: null,
				code: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				}
			}else{
				this.$api.staffSummary.findById(this.dataForm.biofeatureid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormBiofeature.type=res.data.type;
							this.dataFormBiofeature.name=res.data.name;
							this.dataFormBiofeature.code=res.data.code;
							this.dataFormBiofeature.createBy=res.data.createBy;
							this.dataFormBiofeature.createTime=res.data.createTime;
							this.dataFormBiofeature.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormBiofeature.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   变动经历
		handleAddExperience: function () {
			this.editDialogVisibleExperience = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormExperience = {
				id: 0,
				name: null,
				post: null,
				type: null,
				describe: null,
				witness: null,
				pstartdate: null,
				penddate: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				}
			}else{
				this.$api.staffSummary.findById(this.dataForm.experienceid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormExperience.name=res.data.name;
							this.dataFormExperience.post=res.data.post;
							this.dataFormExperience.type=res.data.type;
							this.dataFormExperience.describe=res.data.describe;
							this.dataFormExperience.witness=res.data.witness;
							this.dataFormExperience.pstartdate=res.data.pstartdate;
							this.dataFormExperience.penddate=res.data.penddate;
							this.dataFormExperience.createBy=res.data.createBy;
							this.dataFormExperience.createTime=res.data.createTime;
							this.dataFormExperience.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormExperience.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   家庭信息
		handleAddFamily: function () {
			this.editDialogVisibleFamily = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormFamily = {
				id: 0,
				relationship: null,
				name: null,
				workunits: null,
				postoffice: null,
				contactaddr: null,
				contactnum: null,
				contactemail: null,
				age: null,
				birthday: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				}
			}else{
				this.$api.staffSummary.findById(this.dataForm.familyid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormFamily.relationship=res.data.relationship;
							this.dataFormFamily.name=res.data.name;
							this.dataFormFamily.workunits=res.data.workunits;
							this.dataFormFamily.postoffice=res.data.postoffice;
							this.dataFormFamily.contactaddr=res.data.contactaddr;
							this.dataFormFamily.contactnum=res.data.contactnum;
							this.dataFormFamily.contactemail=res.data.contactemail;
							this.dataFormFamily.age=res.data.age;
							this.dataFormFamily.birthday=res.data.birthday;
							this.dataFormFamily.createBy=res.data.createBy;
							this.dataFormFamily.createTime=res.data.createTime;
							this.dataFormFamily.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormFamily.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   合同信息
		handleAddPact: function () {
			this.editDialogVisiblePact = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormPact = {
				id: 0,
				code: null,
				signtype: null,
				firstparty: null,
				secondparty: null,
				servicelife: null,
				workplace: null,
				workduties: null,
				dispatchagency: null,
				signdate: null,
				pstartdate: null,
				penddate: null,
				regularizationdate: null,
				type: null,
				periodtype: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				}
			}else{
				this.$api.staffSummary.findById(this.dataForm.pactid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormPact.code=res.data.code;
							this.dataFormPact.signtype=res.data.signtype;
							this.dataFormPact.firstparty=res.data.firstparty;
							this.dataFormPact.secondparty=res.data.secondparty;
							this.dataFormPact.servicelife=res.data.servicelife;
							this.dataFormPact.workplace=res.data.workplace;
							this.dataFormPact.workduties=res.data.workduties;
							this.dataFormPact.dispatchagency=res.data.dispatchagency;
							this.dataFormPact.signdate=res.data.signdate;
							this.dataFormPact.pstartdate=res.data.pstartdate;
							this.dataFormPact.penddate=res.data.penddate;
							this.dataFormPact.regularizationdate=res.data.regularizationdate;
							this.dataFormPact.type=res.data.periodtype;
							this.dataFormPact.periodtype=res.data.periodtype;
							this.dataFormPact.createBy=res.data.createBy;
							this.dataFormPact.createTime=res.data.createTime;
							this.dataFormPact.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormPact.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   薪酬福利
		handleAddPayroll: function () {
			this.editDialogVisiblePayroll = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormPayroll = {
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
			}else{
				this.$api.staffSummary.findById(this.dataForm.payrollid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormPayroll.medicalsecuritynum=res.data.medicalsecuritynum;
							this.dataFormPayroll.socialsecuritynum=res.data.socialsecuritynum;
							this.dataFormPayroll.accumulationfundaccount=res.data.accumulationfundaccount;
							this.dataFormPayroll.socialsecurityorganizationrelationship=res.data.socialsecurityorganizationrelationship;
							this.dataFormPayroll.socialsecuritylevel=res.data.socialsecuritylevel;
							this.dataFormPayroll.paymenttype=res.data.paymenttype;
							this.dataFormPayroll.bankaccount=res.data.bankaccount;
							this.dataFormPayroll.salaryregion=res.data.salaryregion;
							this.dataFormPayroll.socialsecuritystartstime=res.data.socialsecuritystartstime;
							this.dataFormPayroll.reservebeginstime=res.data.reservebeginstime;
							this.dataFormPayroll.socialsecuritypaymentbase=res.data.socialsecuritypaymentbase;
							this.dataFormPayroll.reservepaymentbase=res.data.reservepaymentbase;
							this.dataFormPayroll.annuitypaymentbase=res.data.annuitypaymentbase;
							this.dataFormPayroll.paycurrency=res.data.paycurrency;
							this.dataFormPayroll.paybank=res.data.paybank;
							this.dataFormPayroll.createBy=res.data.createBy;
							this.dataFormPayroll.createTime=res.data.createTime;
							this.dataFormPayroll.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormPayroll.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   体检信息
		handleAddPhysical: function () {
			this.editDialogVisiblePhysical = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormPhysical = {
				id: 0,
				achromate: null,
				bloodtype: null,
				hospital: null,
				item: null,
				conclusion: null,
				height: null,
				weight: null,
				eyesightl: null,
				eyesightr: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				}
			}else{
				this.$api.staffSummary.findById(this.dataForm.physicalid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormPhysical.achromate =res.data.achromate;
							this.dataFormPhysical.bloodtype=res.data.bloodtype;
							this.dataFormPhysical.hospital=res.data.hospital;
							this.dataFormPhysical.item=res.data.item;
							this.dataFormPhysical.conclusion=res.data.conclusion;
							this.dataFormPhysical.height=res.data.height;
							this.dataFormPhysical.weight=res.data.weight;
							this.dataFormPhysical.eyesightl=res.data.eyesightl;
							this.dataFormPhysical.eyesightr=res.data.eyesightr;
							this.dataFormPhysical.createBy=res.data.createBy;
							this.dataFormPhysical.createTime=res.data.createTime;
							this.dataFormPhysical.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormPhysical.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   户口信息
		handleAddResident: function () {
			this.editDialogVisibleResident = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormResident = {
				id: 0,
				name: null,
				matename: null,
				matehousetype: null,
				childrenname: null,
				permanentresidence: null,
				immigrationaddr: null,
				emigrationtaddr: null,
				currentaddr: null,
				immigrationtime: null,
				emigrationtime: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				}
			}else{
				this.$api.staffSummary.findById(this.dataForm.residentid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormResident.name=res.data.name;
							this.dataFormResident.matename=res.data.matename;
							this.dataFormResident.matehousetype=res.data.matehousetype;
							this.dataFormResident.childrenname=res.data.childrenname;
							this.dataFormResident.permanentresidence=res.data.permanentresidence;
							this.dataFormResident.immigrationaddr=res.data.immigrationaddr;
							this.dataFormResident.emigrationtaddr=res.data.emigrationtaddr;
							this.dataFormResident.currentaddr=res.data.currentaddr;
							this.dataFormResident.immigrationtime=res.data.immigrationaddr;
							this.dataFormResident.emigrationtime=res.data.emigrationtime;
							this.dataFormResident.createBy=res.data.createBy;
							this.dataFormResident.createTime=res.data.createTime;
							this.dataFormResident.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormResident.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   培训信息
		handleAddTrain: function () {
			this.editDialogVisibleTrain = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormTrain = {
				id: 0,
				starttime: null,
				endtime: null,
				type: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				}
			}else{
				this.$api.staffSummary.findById(this.dataForm.trainid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormTrain.starttime=res.data.starttime;
							this.dataFormTrain.endtime=res.data.endtime;
							this.dataFormTrain.type=res.data.type;
							this.dataFormTrain.createBy=res.data.createBy;
							this.dataFormTrain.createTime=res.data.createTime;
							this.dataFormTrain.lastUpdateBy=res.data.lastUpdateBy;
							this.dataFormTrain.lastUpdateTime=res.data.lastUpdateTime;
	
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},		
// 显示新增界面   联系信息
		handleAddContact: function () {
			this.editDialogVisibleContact = true
			if(!this.operation == false){
				this.operation = true
				this.dataFormContact = {
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
			}else{
				this.$api.staffSummary.findById(this.dataForm.contactid).then((res) => {
					if(res.code == 200) {
							this.$message({ message: '查询成功', type: 'success' })
							this.dataFormContact.cellphone=res.data.cellphone;
							this.dataFormContact.email=res.data.email;
							this.dataFormContact.wechatnum=res.data.wechatnum;
							this.dataFormContact.officephone=res.data.officephone;
							this.dataFormContact.enterprisecornet=res.data.enterprisecornet;
							this.dataFormContact.nativeplace=res.data.nativeplace;
							this.dataFormContact.currentaddr=res.data.currentaddr;
							this.dataFormContact.zipcode=res.data.zipcode;
							this.dataFormContact.urgentcontact=res.data.urgentcontact;
							this.dataFormContact.relationship=res.data.relationship;
							this.dataFormContact.contactphone=res.data.contactphone;
							this.dataFormContact.createBy=res.data.createBy;
							this.dataFormContact.createTime=res.data.createTime;
							this.dataFormContact.lastUpdateBy=res.data,lastUpdateBy;
							this.dataFormContact.lastUpdateTime=res.data.lastUpdateTime;
					} else {
							this.$message({message: '查询失败, ' + res.msg, type: 'error'})
					}
				})
			}
		},																				
		// 显示编辑界面   主界面
		handleEdit: function (params) {
			this.editDialogVisible = true
			this.operation = false
			this.dataForm = Object.assign({}, params.row)
		},
		// 显示编辑界面   进出场记录
		handleEditInout: function (params) {
			this.editDialogVisibleInout = true
			this.operation = false
			this.dataFormInout = Object.assign({}, params.row)
		},
		// 显示编辑界面   协议信息
		handleEditProtocol: function (params) {
			this.editDialogVisibleProtocol = true
			this.operation = false
			this.dataFormProtocol = Object.assign({}, params.row)
		},		
		// 显示编辑界面   基本信息
		handleEditBasic: function (params) {
			this.editDialogVisibleBasicl = true
			this.operation = false
			this.dataFormBiofeature = Object.assign({}, params.row)
		},		
		// 显示编辑界面   生物特征
		handleEditBiofeature: function (params) {
			this.editDialogVisibleBiofeature = true
			this.operation = false
			this.dataFormBiofeature = Object.assign({}, params.row)
		},		
		// 显示编辑界面   联系信息
		handleEditContact: function (params) {
			this.editDialogVisibleContact = true
			this.operation = false
			this.dataFormContact = Object.assign({}, params.row)
		},		
		// 显示编辑界面   合同信息
		handleEditPact: function (params) {
			this.editDialogVisiblePact = true
			this.operation = false
			this.dataFormPact = Object.assign({}, params.row)
		},		
		// 显示编辑界面   薪酬福利
		handleEditPayroll: function (params) {
			this.editDialogVisiblePayroll = true
			this.operation = false
			this.dataFormPayroll = Object.assign({}, params.row)
		},		
		// 显示编辑界面   体检信息
		handleEditPhysical: function (params) {
			this.editDialogVisibleProtocol = true
			this.operation = false
			this.dataFormProtocol = Object.assign({}, params.row)
		},		
		// 显示编辑界面   户口信息
		handleEditResident: function (params) {
			this.editDialogVisibleResident = true
			this.operation = false
			this.dataFormResident = Object.assign({}, params.row)
		},		
		// 显示编辑界面   培训信息
		handleEditTrain: function (params) {
			this.editDialogVisibleTrain = true
			this.operation = false
			this.dataFormTrain = Object.assign({}, params.row)
		},		
		// 显示编辑界面   家庭信息
		handleEditFamily: function (params) {
			this.editDialogVisibleFamily = true
			this.operation = false
			this.dataFormFamily = Object.assign({}, params.row)
		},		
		// 显示编辑界面   变动经历
		handleEditExperience: function (params) {
			this.editDialogVisibleExperience = true
			this.operation = false
			this.dataFormExperience = Object.assign({}, params.row)
		},																						
		// 编辑   主界面
		submitForm: function () {
			this.$refs.dataForm.validate((valid) => {
				if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
						let params = Object.assign({}, this.dataForm)
						this.$api.staffSummary.save(params).then((res) => {
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
// 编辑   进出场记录
		submitFormInout: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormInout)
							this.$api.staffInout.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.inoutid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormInout'].resetFields()
								this.editDialogVisibleInout = false
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
							let params = Object.assign({}, this.dataFormInout)
							params.id = this.dataForm.inoutid
							this.$api.staffInout.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.inoutid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormInout'].resetFields()
								this.editDialogVisibleInout = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},	
// 编辑   协议信息
		submitFormProtocol: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormProtocol)
							this.$api.staffProtocol.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.protocolid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormProtocol'].resetFields()
								this.editDialogVisibleProtocol = false
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
							let params = Object.assign({}, this.dataFormProtocol)
							params.id = this.dataForm.protocolid
							this.$api.staffProtocol.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.protocolid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormProtocol'].resetFields()
								this.editDialogVisibleProtocol = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   基本信息
		submitFormBasic: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormBasic)
							this.$api.staffBasic.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.basicid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormBasic'].resetFields()
								this.editDialogVisibleBasicl = false
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
							params.id = this.dataForm.basicid
							this.$api.staffBasic.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.basicid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormBasic'].resetFields()
								this.editDialogVisibleBasicl = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   生物特征
		submitFormBiofeature: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormBiofeature)
							this.$api.staffBiofeature.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.biofeatureid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormBiofeature'].resetFields()
								this.editDialogVisibleBiofeature = false
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
							let params = Object.assign({}, this.dataFormBiofeature)
							params.id = this.dataForm.biofeatureid
							this.$api.staffBiofeature.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.biofeatureid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormBiofeature'].resetFields()
								this.editDialogVisibleBiofeature = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   联系信息
		submitFormContact: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormContact)
							this.$api.staffContact.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.contactid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormContact'].resetFields()
								this.editDialogVisibleContact = false
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
							let params = Object.assign({}, this.dataFormContact)
							params.id = this.dataForm.contactid
							this.$api.staffContact.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.contactid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormContact'].resetFields()
								this.editDialogVisibleContact = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   变动经历
		submitFormExperience: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormExperience)
							this.$api.staffExperience.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.experienceid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormExperience'].resetFields()
								this.editDialogVisibleExperience = false
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
							let params = Object.assign({}, this.dataFormExperience)
							params.id = this.dataForm.experienceid
							this.$api.staffExperience.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataFormExperience = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormExperience'].resetFields()
								this.editDialogVisibleExperience = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   家庭信息
		submitFormFamily: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormFamily)
							this.$api.staffFamily.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.familyid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormFamily'].resetFields()
								this.editDialogVisibleFamily = false
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
							let params = Object.assign({}, this.dataFormFamily)
							params.id = this.dataForm.familyid
							this.$api.staffFamily.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.familyid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormFamily'].resetFields()
								this.editDialogVisibleFamily = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   合同信息
		submitFormPact: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormPact)
							this.$api.staffPact.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.pactid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormPact'].resetFields()
								this.editDialogVisiblePact = false
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
							let params = Object.assign({}, this.dataFormPact)
							params.id = this.dataForm.pactid
							this.$api.staffPact.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.pactid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormPact'].resetFields()
								this.editDialogVisiblePact = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   薪酬福利
		submitFormPayroll: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormPayroll)
							this.$api.staffPayroll.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.payrollid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormPayroll'].resetFields()
								this.editDialogVisiblePayroll = false
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
							let params = Object.assign({}, this.dataFormPayroll)
							params.id = this.dataForm.payrollid
							this.$api.staffPayroll.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.payrollid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormPayroll'].resetFields()
								this.editDialogVisiblePayroll = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   体检信息
		submitFormPhysical: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormPhysical)
							this.$api.staffPhysical.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.physicalid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormPhysical'].resetFields()
								this.editDialogVisiblePhysical = false
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
							let params = Object.assign({}, this.dataFormPhysical)
							params.id = this.dataForm.physicalid
							this.$api.staffPhysical.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.physicalid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormPhysical'].resetFields()
								this.editDialogVisiblePhysical = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   户口信息
		submitFormResident: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormResident)
							this.$api.staffResident.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.residentid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormResident'].resetFields()
								this.editDialogVisibleResident = false
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
							let params = Object.assign({}, this.dataFormResident)
							params.id = this.dataForm.residentid
							this.$api.staffResident.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.residentid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormResident'].resetFields()
								this.editDialogVisibleResident = false
								this.findPage(null)
							})
						})
					}
				})
			}
		},		
// 编辑   培训信息
		submitFormTrain: function () {
			if(!this.operation == false){
				this.$refs.dataForm.validate((valid) => {
					if (valid) {
						this.$confirm('确认提交吗？', '提示', {}).then(() => {
							this.editLoading = true
							let params = Object.assign({}, this.dataFormTrain)
							this.$api.staffTrain.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.trainid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormTrain'].resetFields()
								this.editDialogVisibleTrain = false
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
							let params = Object.assign({}, this.dataFormTrain)
							params.id = this.dataForm.trainid
							this.$api.staffTrain.save(params).then((res) => {
								if(res.code == 200) {
									this.$message({ message: '操作成功', type: 'success' })
									this.dataForm.trainid = res.data;
								} else {
									this.$message({message: '操作失败, ' + res.msg, type: 'error'})
								}
								this.editLoading = false
								this.$refs['dataFormTrain'].resetFields()
								this.editDialogVisibleTrain = false
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