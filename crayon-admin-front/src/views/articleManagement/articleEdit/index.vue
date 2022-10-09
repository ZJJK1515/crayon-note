<template>
  <div class="index-container">
    <el-divider content-position="left">文章编辑</el-divider>
    <el-form
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="70px"
      class="demo-ruleForm"
    >
      <el-form-item label="文章标题" prop="name">
        <el-input v-model="title" aria-placeholder="asdas">tests</el-input>
      </el-form-item>
    </el-form>
    <vab-mavon-editor
      ref="md"
      v-model="content"
      style="min-height: 600px"
      @change="change"
    />
    <button @click="submit">提交</button>
  </div>
</template>
<script>
  import VabMavonEditor from '@/plugins/mavonEditor'

  export default {
    name: 'ArticleEdit',
    components: { VabMavonEditor },
    data() {
      return {
        title: '',
        content: '',
        html: '',
      }
    },
    created() {},
    mounted() {},
    methods: {
      change(value, render) {
        this.html = render
      },
      submit() {
        console.log(this.content)
        console.log(this.html)
      },
    },
  }
</script>
