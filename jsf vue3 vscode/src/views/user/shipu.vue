<script setup>
import jsc1 from'../../assets/jsc1.jpg'
import jsc2 from'../../assets/jsc2.jpg'
import jsc3 from'../../assets/jsc3.jpg'
import jsc4 from'../../assets/jsc4.jpg'
import jsc5 from'../../assets/jsc5.jpg'




const images = [
   jsc1,
   jsc2,
   jsc3,
   jsc4,
   jsc5
];
</script>

<template>
    <el-carousel :interval="4000" type="card" height="250px">
        <el-carousel-item v-for="(image, index) in images" :key="index">
            <img :src="image" alt="食谱图片" style="width: 100%; height: 100%; object-fit: cover;">
        </el-carousel-item>
    </el-carousel>
    <br>
    <div class="text-container">
        <h3>经济实惠健身餐食谱一周七天：自制餐家常菜最实惠</h3>
        <div class="card-row">
            <div class="recipe-card">
                <strong>星期一</strong><br>
                早餐：牛奶 + 燕麦 + 半根黄瓜 + 半根胡萝卜<br>
                午餐：鸡肉 + 玉米面馒头 + 白菜豆腐汤 + 凉拌西蓝花木耳<br>
                晚餐：酸奶 + 自制蔬菜锅 + 半块馒头或菜包子<br><br>
            </div>
            <div class="recipe-card">
                <strong>星期二</strong><br>
                早餐：2 个鸡蛋 + 1 个苹果 + 小米粥<br>
                午餐：酸奶 + 自制减脂餐(紫米饭 + 3 颗西蓝花 + 西红柿 + 西红柿 + 黄瓜 + 木耳 + 洋葱 + 青椒)<br>
                晚餐：西红柿鸡蛋汤 + 菜包子<br><br>
            </div>
            <div class="recipe-card">
                <strong>星期三</strong><br>
                早餐：牛奶 + 半块玉米面馒头 + 香蕉<br>
                午餐：自制营养汤面(拉面 + 鸡肉丁 + 西红柿 + 白菜 + 生菜) + 1 根黄瓜或胡萝卜<br>
                晚餐：白萝卜汤 + 西红柿 + 炒四季豆 + 小碗米饭<br><br>
            </div>
            <div class="recipe-card">
                <strong>星期四</strong><br>
                早餐：牛奶 + 燕麦 + 胡萝卜<br>
                午餐：炒豆芽 + 凉拌西蓝花和木耳 + 些许牛肉 + 1 碗米饭<br>
                晚餐：自制蔬菜锅 + 酸奶<br><br>
            </div>
            <div class="recipe-card">
                <strong>星期五</strong><br>
                早餐：豆浆 + 香蕉 + 菜包子<br>
                午餐：鱼汤 + 西红柿 + 小碗米饭<br>
                晚餐：鱼汤 + 粗粮馒头 + 凉拌木耳<br><br>
            </div>
            <div class="recipe-card">
                <strong>星期六</strong><br>
                早餐：鸡蛋 + 全麦面包 + 香蕉 + 一杯茶<br>
                午餐：绿豆汤 + 自制减脂餐<br>
                晚餐：蔬菜汤 + 凉拌西蓝花 + 西红柿<br><br>
            </div>
            <div class="recipe-card">
                <strong>星期天</strong><br>
                早餐：牛奶 + 全麦面包 + 苹果 + 一本茶<br>
                午餐：自制营养汤面<br>
                晚餐：酸奶 + 自制蔬菜锅<br><br>
            </div>
        </div>
    </div>
</template>

<style scoped>
.el-carousel__item h3 {
    color: #475669;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
    text-align: center;
}

.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
}

.text-container {
    width: 100%;
    margin: 20px auto;
    text-align: left;
    font-size: 14px;
    line-height: 1.5;
    color: #333;
    border-top: 1px solid #ccc;
}

.card-row {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}

.recipe-card {
    width: 45%;
    padding: 15px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    background-color: #fff;
    margin-bottom: 20px;
}
</style>