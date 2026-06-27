<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'
// 评论数据模型
const categorys = ref([])
// 用户搜索时选中的分类id
const categoryId = ref('')
// 评论数据模型
const articles = ref([
    {
        "id": '',
        "user_id": '',
        "pl": '',
        "fabiaotime": ''
    }
])
// 分页条数据模型
const pageNum = ref(1) // 当前页
const total = ref(20) // 总条数
const pageSize = ref(3) // 每页条数

// 当每页条数发生了变化，调用此函数
const onSizeChange = (size) => {
    pageSize.value = size
    pageNum.value=1;
    articleList()
}
// 当前页码发生变化，调用此函数
const onCurrentChange = (num) => {
    pageNum.value = num
    articleList()
}

// 获取评论列表数据
import { PlListService, PlAddService } from '@/api/pl';
const articleList = async () => {
    try {
        let result = await PlListService({
            pageNum: pageNum.value,
            pageSize: pageSize.value
    });
        articles.value = result.data;
        console.log(articles.value)
    } catch (error) {
        console.error("获取评论数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}
onMounted(() => {
    articleList();
})

import { Plus } from '@element-plus/icons-vue'
// 控制抽屉是否显示
const visibleDrawer = ref(false)
// 添加表单数据模型
const articleModel = ref({
    id: '',
    user_id: '',
    pl: '',
    fabiaotime: '',
})

// 添加评论
import {ElMessage} from 'element-plus'
const addArticle = async () => {
    // 调用接口
    let result = await PlAddService(articleModel.value);

    ElMessage.success(result.msg? result.msg : '添加成功');

    // 让抽屉消失
    visibleDrawer.value = false;

    // 刷新当前列表
    articleList();
}
</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>评论</span>
                <div class="extra">
                    <el-button type="primary" @click="visibleDrawer = true">发表评论</el-button>
                </div>
            </div>
        </template>

        <!-- 文章列表 -->
        <el-table :data="articles" style="width: 100%">
            <el-table-column label="内容" width="400" prop="pl"></el-table-column>
            <el-table-column label="发表人" prop="username"></el-table-column>
            <el-table-column label="发表时间" prop="fabiaotime"> </el-table-column>

            <template #empty>
                <el-empty description="没有数据" />
            </template>
        </el-table>

        <!-- 分页条 -->
        <!-- <el-pagination v-model:current-page="pageNum" v-model:page-size="pageSize" :page-sizes="[3, 5, 10, 15]"
            layout="jumper, total, sizes, prev, pager, next" background :total="total" @size-change="onSizeChange"
            @current-change="onCurrentChange" style="margin-top: 20px; justify-content: flex-end" /> -->

        <!-- 抽屉 -->
        <el-drawer v-model="visibleDrawer" title="发表评论" direction="rtl" size="50%" >
            <!-- 添加评论表单 -->
            <el-form :model="articleModel" label-width="100px">
                <el-form-item label="评论">
                    <el-input v-model="articleModel.pl" placeholder="请输入评论" style="width: 300px; height: 100px;"></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="addArticle()">发布</el-button>
                </el-form-item>
            </el-form>
        </el-drawer>
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

/* 抽屉样式 */
.avatar-uploader {
    :deep() {
       .avatar {
            width: 178px;
            height: 178px;
            display: block;
        }

       .el-upload {
            border: 1px dashed var(--el-border-color);
            border-radius: 6px;
            cursor: pointer;
            position: relative;
            overflow: hidden;
            transition: var(--el-transition-duration-fast);
        }

       .el-upload:hover {
            border-color: var--el-color-primary;
        }

       .el-icon.avatar-uploader-icon {
            font-size: 28px;
            color: #8c939d;
            width: 178px;
            height: 178px;
            text-align: center;
        }
    }
}

.editor {
    width: 100%;

    :deep(.ql-editor) {
        min-height: 200px;
    }
}
</style>