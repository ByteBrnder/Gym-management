<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'

const jiaolians = ref([])


import { JiaolianAddService,JiaolianDeleteService,JiaolianListService,JiaolianupdateService } from '@/api/jiaolian';



// 异步函数
const AllJiaolianList = async () => {
    try {
        let result = await JiaolianListService();           
        jiaolians.value = result.data;
        console.log(jiaolians.value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
    AllJiaolianList();
})


//控制添加分类弹窗
const dialogVisible = ref(false)

//添加分类数据模型
const jiaolianModel = ref({

    name: '',
    old: '',
    xinbie:'',
    sckc:'',
    phone:''
})
//添加分类表单校验
const rules = {
    name: [
        { required: true, message: '请输入课程名称', trigger: 'blur' },
    ],
    old: [
        { required: true, message: '请输入教练名称', trigger: 'blur' },
    ],
    xinbie: [
        { required: true, message: '请输入课程时间', trigger: 'blur' },
    ],
   sckc: [
        { required: true, message: '请输入所需会员卡等级', trigger: 'blur' },
    ]
}


//调用接口,添加表单
import { ElMessage } from 'element-plus'
const addJiaolian = async () => {
    //调用接口
    let result = await JiaolianAddService(jiaolianModel.value);
    ElMessage.success(result.msg ? result.msg : '添加成功')

    //调用获取所有文章分类的函数
    AllJiaolianList();
    dialogVisible.value = false;
}

//定义变量,控制标题的展示
const title = ref('')

//展示编辑弹窗
const showDialog = (row) => {
    dialogVisible.value = true; title.value = '编辑教练'
    //数据拷贝
    jiaolianModel.value.name = row.name;
    jiaolianModel.value.old = row.old;
    jiaolianModel.value.xinbie = row.xinbie;
    jiaolianModel.value.sckc = row.sckc;
    jiaolianModel.value.phone=row.phone;
    
    //扩展id属性,将来需要传递给后台,完成分类的修改
    jiaolianModel.value.id = row.id
}

//编辑分类
const updateJiaolian = async () => {
    //调用接口
    let result = await JiaolianupdateService(jiaolianModel.value);

    ElMessage.success(result.msg ? result.msg : '修改成功')

    //调用获取所有分类的函数
    AllJiaolianList();

    //隐藏弹窗
    dialogVisible.value = false;
}

//清空模型的数据
const clearData = () => {
    jiaolianModel.value.name = '';
    jiaolianModel.value.old = '';
    jiaolianModel.value.xinbie = '';
    jiaolianModel.value.sckc = '';
    jiaolianModel.value.phone='';
}

 //删除分类
 import {ElMessageBox} from 'element-plus'
 const deleteCategory = (row) => {
     //提示用户  确认框

     ElMessageBox.confirm(
         '你确认要删除该教练信息吗?',
         '温馨提示',
        {
             confirmButtonText: '确认',
             cancelButtonText: '取消',
             type: 'warning',
         }
     )
         .then(async () => {
             //调用接口
             let result = await JiaolianDeleteService(row.id);
             ElMessage({
                 type: 'success',
                 message: '删除成功',
             })
             //刷新列表
             AllJiaolianList();
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
                <span>教练管理</span>
                <div class="extra">
                    <el-button type="primary" @click="dialogVisible = true; title = '添加教练';clearData() ">添加教练</el-button>
                </div>
            </div>
        </template>
        <el-table :data="jiaolians" style="width: 100%">
            
            
            <el-table-column label="教练姓名" prop="name"></el-table-column>
            <el-table-column label="教练年龄" prop="old"></el-table-column>
            <el-table-column label="性别" prop="xinbie" ></el-table-column>
            <el-table-column label="擅长课程" prop="sckc" ></el-table-column>
            <el-table-column label="电话" prop="phone" ></el-table-column>
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
            <el-form :model="jiaolianModel" :rules="rules" label-width="100px" style="padding-right: 30px">
                <el-form-item label="教练姓名" prop="name">
                    <el-input v-model="jiaolianModel.name" minlength="1" maxlength="10"></el-input>
                </el-form-item>
                <el-form-item label="教练年龄" prop="old">
                    <el-input v-model="jiaolianModel.old" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="xinbie">
                    <el-input v-model="jiaolianModel.xinbie" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                <el-form-item label="擅长课程" prop="sckc">
                    <el-input v-model="jiaolianModel.sckc" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                <el-form-item label="电话" prop="phone">
                    <el-input v-model="jiaolianModel.phone" minlength="1" maxlength="15"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="title == '添加教练' ? addJiaolian() : updateJiaolian()"> 确认 </el-button>
               
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






