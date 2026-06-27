<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'

const scores = ref([])

import { AdminUserAddService,AdminUserDeleteService,AdminUserListService,AdminUserupdateService } from '@/api/AdminUser';



// 异步函数
const AllScoreList = async () => {
    try {
        let result = await AdminUserListService();           
        scores.value = result.data;
        console.log(scores.value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
    AllScoreList();
})


//控制添加分类弹窗
const dialogVisible = ref(false)

//添加分类数据模型
const scoreModel = ref({
    id:'',
    username: '',
    password: '',
    old:'',
    xinbie:'',
    phone:'',
   
    isadmin:''
})
//添加分类表单校验
const rules = {
    id: [
        { required: true, message: '请输入用户id', trigger: 'blur' },
    ],
    username: [
        { required: true, message: '请输入用户名称', trigger: 'blur' },
    ],
    password: [
        { required: true, message: '请输入用户密码', trigger: 'blur' },
    ],
    
    isadmin: [
        { required: true, message: '请输入是(true)否(false)为管理员', trigger: 'blur' },
    ]
}


//调用接口,添加表单
import { ElMessage } from 'element-plus'
const addScore = async () => {
    //调用接口
    let result = await AdminUserAddService(scoreModel.value);
    ElMessage.success(result.msg ? result.msg : '添加成功')

    //调用获取所有文章分类的函数
    AllScoreList();
    dialogVisible.value = false;
}
console.log(scoreModel.value.password);
//定义变量,控制标题的展示
const title = ref('')

//展示编辑弹窗
const showDialog = (row) => {
    dialogVisible.value = true; title.value = '编辑用户'
    //数据拷贝
    scoreModel.value.id = row.id;
    scoreModel.value.username = row.username;
    scoreModel.value.password = row.password;
    scoreModel.value.old = row.old;
    scoreModel.value.xinbie = row.xinbie;
    scoreModel.value.phone = row.phone;
    scoreModel.value.isadmin = row.isadmin;

    
    //扩展id属性,将来需要传递给后台,完成分类的修改
    //scoreModel.value.id = row.id
}

//编辑分类
const updateScore = async () => {
    //调用接口
    let result = await AdminUserupdateService(scoreModel.value);

    ElMessage.success(result.msg ? result.msg : '修改成功')

    //调用获取所有分类的函数
    AllScoreList();

    //隐藏弹窗
    dialogVisible.value = false;
}

//清空模型的数据
const clearData = () => {
    scoreModel.value.id = '';
    scoreModel.value.username = '';
    scoreModel.value.password = '';
    scoreModel.value.old = '';
    scoreModel.value.xinbie = '';
    scoreModel.value.phone = '';
    scoreModel.value.isadmin = '';
}

 //删除分类
 import {ElMessageBox} from 'element-plus'
 const deleteCategory = (row) => {
     //提示用户  确认框

     ElMessageBox.confirm(
         '你确认要删除该用户信息吗?',
         '温馨提示',
        {
             confirmButtonText: '确认',
             cancelButtonText: '取消',
             type: 'warning',
         }
     )
         .then(async () => {
             //调用接口
             let result = await AdminUserDeleteService(row.id);
             ElMessage({
                 type: 'success',
                 message: '删除成功',
             })
             //刷新列表
             AllScoreList();
         })
         .catch(() => {
             ElMessage({
                 type: 'info',
                 message: '用户取消了删除',
             })
         })
 }
</script>
<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>用户管理</span>
                <div class="extra">
                    <el-button type="primary" @click="dialogVisible = true; title = '添加器材';clearData() ">添加用户</el-button>
                </div>
            </div>
        </template>
        <el-table :data="scores" style="width: 100%">
            
            <el-table-column label="用户id" prop="id"></el-table-column>
            <el-table-column label="用户名称" prop="username"></el-table-column>
            <el-table-column label="用户密码" prop="password"></el-table-column>
            <el-table-column label="年龄" prop="old" ></el-table-column>
            <el-table-column label="性别" prop="xinbie" ></el-table-column>
            <el-table-column label="电话" prop="phone" ></el-table-column>
            <el-table-column label="入会日期" prop="ruhuirq" ></el-table-column>
            <el-table-column label="是否为管理员" prop="isadmin" ></el-table-column>
            <el-table-column label="操作" width="100">
                <template #default="{ row }">
                    <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)"></el-button>
                    <el-button :icon="Delete" circle plain type="danger" @click="deleteCategory(row)"></el-button>
                </template>
            </el-table-column>
            <template #empty>
                <el-empty description="没有数据" />
            </template>
        </el-table>

        <!-- 添加分类弹窗 -->
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="scoreModel" :rules="rules" label-width="100px" style="padding-right: 30px">
                <el-form-item label="用户id" prop="id">
                    <el-input v-model="scoreModel.id" minlength="1" maxlength="10"></el-input>
                </el-form-item>
                <el-form-item label="用户名称" prop="username">
                    <el-input v-model="scoreModel.username" minlength="1" maxlength="10"></el-input>
                </el-form-item>
                <el-form-item label="用户密码" prop="password">
                    <el-input v-model="scoreModel.password" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                <el-form-item label="年龄" prop="old">
                    <el-input v-model="scoreModel.old" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="xinbie">
                    <el-input v-model="scoreModel.xinbie" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                <el-form-item label="电话" prop="phone">
                    <el-input v-model="scoreModel.phone" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                <el-form-item label="是否为管理员" prop="isadmin">
                    <el-input v-model="scoreModel.isadmin" minlength="1" maxlength="15"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="title == '添加器材' ? addScore() : updateScore()"> 确认 </el-button>
               
                </span>
            </template>
        </el-dialog>
    </el-card>
</template>

<style lang="scss" scoped>
.page-container {
    min-height: 100%;
    box-sizing: border-box;

    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
}
</style>






