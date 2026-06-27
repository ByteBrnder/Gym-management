<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'

const tuankes = ref([])


import { TuanKeListService,TuankeAddService,TuankeDeleteService,TuankeupdateService } from '@/api/tuanke';



// 异步函数
const AllTuankeList = async () => {
    try {
        let result = await TuanKeListService();           
        tuankes.value = result.data;
        console.log(tuankes.value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
    AllTuankeList();
})


//控制添加分类弹窗
const dialogVisible = ref(false)

//添加分类数据模型
const tuankeModel = ref({
    tkname: '',
    jiaolian: '',
    kctime:'',
    
})
//添加分类表单校验
const rules = {
    tkname: [
        { required: true, message: '请输入团课名称', trigger: 'blur' },
    ],
    jiaolian: [
        { required: true, message: '请输入教练名称', trigger: 'blur' },
    ],
    kctime: [
        { required: true, message: '请输入课程时间', trigger: 'blur' },
    ]
   
}


//调用接口,添加表单
import { ElMessage } from 'element-plus'
const addTuanke = async () => {
    //调用接口
    let result = await TuankeAddService(tuankeModel.value);
    ElMessage.success(result.msg ? result.msg : '添加成功')

    //调用获取所有文章分类的函数
    AllTuankeList();
    dialogVisible.value = false;
}

//定义变量,控制标题的展示
const title = ref('')

//展示编辑弹窗
const showDialog = (row) => {
    dialogVisible.value = true; title.value = '编辑课程'
    //数据拷贝
    tuankeModel.value.tkname = row.tkname;
    tuankeModel.value.jiaolian = row.jiaolian;
    tuankeModel.value.kctime = row.kctime;
   
    
    //扩展id属性,将来需要传递给后台,完成分类的修改
    tuankeModel.value.id = row.id
}

//编辑分类
const updateTuanke = async () => {
    //调用接口
    let result = await TuankeupdateService(tuankeModel.value);

    ElMessage.success(result.msg ? result.msg : '修改成功')

    //调用获取所有分类的函数
    AllTuankeList();

    //隐藏弹窗
    dialogVisible.value = false;
}

//清空模型的数据
const clearData = () => {
    tuankeModel.value.tkname = '';
    tuankeModel.value.jiaolian = '';
    tuankeModel.value.kctime = '';
  
}

 //删除分类
 import {ElMessageBox} from 'element-plus'
 const deleteCategory = (row) => {
     //提示用户  确认框

     ElMessageBox.confirm(
         '你确认要删除该团课信息吗?',
         '温馨提示',
        {
             confirmButtonText: '确认',
             cancelButtonText: '取消',
             type: 'warning',
         }
     )
         .then(async () => {
             //调用接口
             let result = await TuankeDeleteService(row.id);
             ElMessage({
                 type: 'success',
                 message: '删除成功',
             })
             //刷新列表
             AllTuankeList();
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
                <span>团课管理</span>
                <div class="extra">
                    <el-button type="primary" @click="dialogVisible = true; title = '添加团课';clearData() ">添加团课</el-button>
                </div>
            </div>
        </template>
        <el-table :data="tuankes" style="width: 100%">
            
            
            <el-table-column label="团课名称" prop="tkname"></el-table-column>
            <el-table-column label="教练" prop="jiaolian"></el-table-column>
            <el-table-column label="课程时间" prop="kctime" ></el-table-column>

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
            <el-form :model="tuankeModel" :rules="rules" label-width="100px" style="padding-right: 30px">
                <el-form-item label="团课名称" prop="tkname">
                    <el-input v-model="tuankeModel.tkname" minlength="1" maxlength="10"></el-input>
                </el-form-item>
                <el-form-item label="教练" prop="jiaolian">
                    <el-input v-model="tuankeModel.jiaolian" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                <el-form-item label="课程时间" prop="kctime">
                    <el-input v-model="tuankeModel.kctime" minlength="1" maxlength="15"></el-input>
                </el-form-item>
                
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="title == '添加团课' ? addTuanke() : updateTuanke()"> 确认 </el-button>
               
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






