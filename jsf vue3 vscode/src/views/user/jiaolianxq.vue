<script setup>
import yanjunhuajiaolianImage from'../../assets/yanjunhuajiaolian.jpg'
import lulujiaolianImage from'../../assets/lulujiaolian.jpg'
import tanyuejiaolianImage from'../../assets/tanyuejiaolian.jpg'
import heyizhengjiaolianImage from'../../assets/heyizhengjiaolian.jpg'
import hezhiruijiaolianImage from'../../assets/hezhiruijiaolian.jpg'
import shashajiaolianImage from'../../assets/shashajiaolian.png'
import jiangwujiaolianImage from'../../assets/jiangwujiaolian.jpg'


</script>

<template>
  
  
    <el-descriptions
      title="教练详情"
      direction="vertical"
      border
      style="margin-top: 20px"
    >
      <el-descriptions-item
        :rowspan="2"
        :width="140"
        label="照片"
        align="center"
      >
        <el-image
          style="width: 160px; height: 240px"
            :src=" yanjunhuajiaolianImage"
        
        />
        
      </el-descriptions-item>
      <el-descriptions-item label="姓名">颜俊华</el-descriptions-item>
      <el-descriptions-item label="电话">18135878971</el-descriptions-item>
      <el-descriptions-item label="年龄">45</el-descriptions-item>
      <el-descriptions-item label="性别">男</el-descriptions-item>
      <el-descriptions-item label="介绍">
        从业十年，擅长燃脂训练，国家一级运动员，国家职业资格高级认证，2014奥林匹亚先生赛健美冠军
      </el-descriptions-item>
    </el-descriptions>

    <el-descriptions
       
      direction="vertical"
      border
      style="margin-top: 50px"
    >
      <el-descriptions-item
        :rowspan="2"
        :width="140"
        label="照片"
        align="center"
      >
        <el-image
          style="width: 160px; height: 240px"
            :src="lulujiaolianImage"
        
        />
        
      </el-descriptions-item>
      <el-descriptions-item label="姓名">璐璐</el-descriptions-item>
      <el-descriptions-item label="电话">1734121141</el-descriptions-item>
      <el-descriptions-item label="年龄">30</el-descriptions-item>
      <el-descriptions-item label="性别">女</el-descriptions-item>
      <el-descriptions-item label="介绍">
        从业四年，擅长腰臀训练，国家二级运动员，国家职业资格高级认证
      </el-descriptions-item>
    </el-descriptions>

    <el-descriptions
       
      direction="vertical"
      border
      style="margin-top: 50px"
    >
      <el-descriptions-item
        :rowspan="2"
        :width="140"
        label="照片"
        align="center"
      >
        <el-image
          style="width: 160px; height: 240px"
            :src="tanyuejiaolianImage"
        
        />
        
      </el-descriptions-item>
      <el-descriptions-item label="姓名">谭乐</el-descriptions-item>
      <el-descriptions-item label="电话">17238793445</el-descriptions-item>
      <el-descriptions-item label="年龄">45</el-descriptions-item>
      <el-descriptions-item label="性别">男</el-descriptions-item>
      <el-descriptions-item label="介绍">
        从业十年，擅长力量训练，国家职业资格高级认证，2016中国区拳赛第一名
      </el-descriptions-item>
    </el-descriptions>

    <el-descriptions
       
      direction="vertical"
      border
      style="margin-top: 50px"
    >
      <el-descriptions-item
        :rowspan="2"
        :width="140"
        label="照片"
        align="center"
      >
        <el-image
           style="width: 160px; height: 240px"
            :src="heyizhengjiaolianImage"
        
        />
        
      </el-descriptions-item>
      <el-descriptions-item label="姓名">贺易正</el-descriptions-item>
      <el-descriptions-item label="电话">17638466676</el-descriptions-item>
      <el-descriptions-item label="年龄">41</el-descriptions-item>
      <el-descriptions-item label="性别">男</el-descriptions-item>
      <el-descriptions-item label="介绍">
        从业十年，擅长腹肌训练，国家职业资格高级认证,中国国家队健体运动员
      </el-descriptions-item>
    </el-descriptions>

    <el-descriptions
       
      direction="vertical"
      border
      style="margin-top: 50px"
    >
      <el-descriptions-item
        :rowspan="2"
        :width="140"
        label="照片"
        align="center"
      >
        <el-image
           style="width: 160px; height: 240px"
            :src="hezhiruijiaolianImage"
        
        />
        
      </el-descriptions-item>
      <el-descriptions-item label="姓名">贺智睿</el-descriptions-item>
      <el-descriptions-item label="电话">18178905676</el-descriptions-item>
      <el-descriptions-item label="年龄">42</el-descriptions-item>
      <el-descriptions-item label="性别">男</el-descriptions-item>
      <el-descriptions-item label="介绍">
        从业七年，擅长腿部训练，国家一级运动员，国家职业资格高级认证，2015奥林匹亚先生赛健体冠军
      </el-descriptions-item>
    </el-descriptions>

    <el-descriptions
        
      direction="vertical"
      border
      style="margin-top: 50px"
    >
      <el-descriptions-item
        :rowspan="2"
        :width="140"
        label="照片"
        align="center"
      >
        <el-image
          style="width: 170px; height: 230px"
            :src="shashajiaolianImage"
        
        />
        
      </el-descriptions-item>
      <el-descriptions-item label="姓名">莎莎</el-descriptions-item>
      <el-descriptions-item label="电话">17889001321</el-descriptions-item>
      <el-descriptions-item label="年龄">29</el-descriptions-item>
      <el-descriptions-item label="性别">女</el-descriptions-item>
      <el-descriptions-item label="介绍">
        从业二年，擅长腰部训练，国家一级体操运动员，国家职业资格高级认证
      </el-descriptions-item>
    </el-descriptions>

    <el-descriptions
        
      direction="vertical"
      border
      style="margin-top: 50px"
    >
      <el-descriptions-item
        :rowspan="2"
        :width="140"
        label="照片"
        align="center"
      >
        <el-image
           style="width: 160px; height: 240px"
            :src="jiangwujiaolianImage"
        
        />
        
      </el-descriptions-item>
      <el-descriptions-item label="姓名">姜武</el-descriptions-item>
      <el-descriptions-item label="电话">18901458900</el-descriptions-item>
      <el-descriptions-item label="年龄">36</el-descriptions-item>
      <el-descriptions-item label="性别">男</el-descriptions-item>
      <el-descriptions-item label="介绍">
        从业四年，擅长力量训练，国家一级运动员，国家职业资格高级认证,2016奥林匹亚业余赛冠军
      </el-descriptions-item>
    </el-descriptions>

   
  </template>