<template>
  <div class="container">
    <div class="form-container">
      <form @submit.prevent="postData" method="post" action="Home.vue">
        <h3>APPLICATION FORM</h3>
        <div class="form-group">
          <label>Job Title:</label>
          <select required class="ms-3" id="job" v-model="posts.title">
            <option v-for="title in titles"
                    v-bind:key="title.id">{{title.jobTitle}}</option>
          </select>
        </div>
        <div class="form-group">
          <label>Name</label>
          <input required type="text" v-model="posts.name" class="form-control form-control-lg">
        </div>
        <div class="form-group">
          <label>Email Address</label>
          <input required type="email" v-model="posts.email" class="form-control form-control-lg" >
        </div>
        <div class="form-group">
          <label>Phone Number</label>
          <input required type="text" v-model="posts.phoneNumber"
                 class="form-control form-control-lg">
        </div>
        <div class="form-group">
          <label>Address</label>
          <input required type="text" v-model="posts.address" class="form-control form-control-lg">
        </div>
        <div class="form-group">
          <label>Comment</label>
          <input required type="text" v-model="posts.comment" class="form-control form-control-lg">
        </div>
        <button type="submit" class="btn btn-dark btn-lg btn-block mt-3"> Apply </button>
      </form>
    </div>
  </div>
</template>

<script>
import Vue from 'vue';
// eslint-disable-next-line import/no-extraneous-dependencies
import axios from 'axios';
import VueAxios from 'vue-axios';

Vue.use(VueAxios, axios);
export default {
  name: 'ApplicantForm',
  data() {
    return {
      posts: {
        title: '',
        name: '',
        email: '',
        phoneNumber: '',
        address: '',
        comment: '',
      },
      titles: [],
    };
  },
  methods: {
    postData(e) {
      this.axios.post('http://localhost:8070/applicant/apply-to-job', this.posts)
        .then((result) => {
          // eslint-disable-next-line no-console
          console.warn(result);
        });
      e.preventDefault();
      this.$router.push({ path: '/' });
    },
    async getData() {
      try {
        const response = await fetch('http://localhost:8070/job/job-list');
        this.titles = await response.json();
      } catch (error) {
        // eslint-disable-next-line no-console
        console.log(error);
      }
    },
  },
  created() {
    this.getData();
  },
};
</script>

<style scoped>

</style>
