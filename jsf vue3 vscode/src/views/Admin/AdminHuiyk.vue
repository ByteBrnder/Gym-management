<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'

const huiyuankas = ref([])


import { HuiyuankaAddService,HuiyuankaDeleteService,HuiyuankaListService,HuiyuankaupdateService } from '@/api/huiyuanka';



// 异步函数
const AllHuiyuankaList = async () => {
    try {
        let result = await HuiyuankaListService();           
        huiyuankas.value = result.data;
        console.log(huiyuankas.value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
    AllHuiyuankaList();
})


//控制添加分类弹窗
const dialogVisible = ref(false)

//添加分类数据模型
const huiyuankaModel = ref({
    dengji: '',
    jiage: '',
  
    
})
//添加分类表单校验
const rules = {
    dengji: [
        { required: true, message: '请输入会员卡等级', trigger: 'blur' },
    ],
    jiage: [
        { required: true, message: '请输入价格', trigger: 'blur' },
    ]
   
   
}


//调用接口,添加表单
import { ElMessage } from 'element-plus'
const addHuiyuanka = async () => {
    //调用接口
    let result = await HuiyuankaAddService(huiyuankaModel.value);
    ElMessage.success(result.msg ? result.msg : '添加成功')

    //调用获取所有文章分类的函数
    AllHuiyuankaList();
    dialogVisible.value = false;
}

//定义变量,控制标题的展示
const title = ref('')

//展示编辑弹窗
const showDialog = (row) => {
    dialogVisible.value = true; title.value = '编辑会员卡'
    //数据拷贝
    huiyuankaModel.value.dengji = row.dengji;
    huiyuankaModel.value.jiage = row.jiage;
  
   
    
    //扩展id属性,将来需要传递给后台,完成分类的修改
    huiyuankaModel.value.id = row.id
}

//编辑分类
const updateHuiyuanka = async () => {
    //调用接口
    let result = await HuiyuankaupdateService(huiyuankaModel.value);

    ElMessage.success(result.msg ? result.msg : '修改成功')

    //调用获取所有分类的函数
    AllHuiyuankaList();

    //隐藏弹窗
    dialogVisible.value = false;
}

//清空模型的数据
const clearData = () => {
    huiyuankaModel.value.dengji = '';
    huiyuankaModel.value.jiage = '';
   
  
}

 //删除分类
 import {ElMessageBox} from 'element-plus'
 const deleteCategory = (row) => {
     //提示用户  确认框

     ElMessageBox.confirm(
         '你确认要删除该会员卡信息吗?',
         '温馨提示',
        {
             confirmButtonText: '确认',
             cancelButtonText: '取消',
             type: 'warning',
         }
     )
         .then(async () => {
             //调用接口
             let result = await HuiyuankaDeleteService(row.id);
             ElMessage({
                 type: 'success',
                 message: '删除成功',
             })
             //刷新列表
             AllHuiyuankaList();
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
                <span>会员卡管理</span>
                <div class="extra">
                    <el-button type="primary" @click="dialogVisible = true; title = '添加会员卡';clearData() ">添加会员卡</el-button>
                </div>
            </div>
        </template>
        <el-table :data="huiyuankas" style="width: 100%">
            
            
            <el-table-column label="会员卡等级" prop="dengji"></el-table-column>
            <el-table-column label="价格" prop="jiage"></el-table-column>
           

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
            <el-form :model="huiyuankaModel" :rules="rules" label-width="100px" style="padding-right: 30px">
                <el-form-item label="会员卡等级" prop="dengji">
                    <el-input v-model="huiyuankaModel.dengji" minlength="1" maxlength="10"></el-input>
                </el-form-item>
                <el-form-item label="价格" prop="jiage">
                    <el-input v-model="huiyuankaModel.jiage" minlength="1" maxlength="15"></el-input>
                </el-form-item>
               
                
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="title == '添加会员卡' ? addHuiyuanka() : updateHuiyuanka()"> 确认 </el-button>
               
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






