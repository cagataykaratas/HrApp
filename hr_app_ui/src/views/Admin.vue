<template>
  <div class="list-container w-75 mt-5">
    <table id="job-list" class="table ms-5">
      <thead>
      <tr>
        <th v-for="col in columns" v-bind:key="col.id">{{col}}</th>
      </tr>
      </thead>
      <tbody>
        <tr v-for="job in jobs" v-bind:key="job.id">
          <td>{{job.jobTitle}}</td>
          <td>{{job.jobDescription}}</td>
          <td>{{job.numberOfPeople}}</td>
          <td>{{job.applicationDate}}</td>
        </tr>
      </tbody>
    </table>
    <div class="add-job-button float-end">
      <router-link to="/add-job"><input type="button" value="Add Job"></router-link>
    </div>
    <div class="show-container">
      <div class="applicants mt-5 ms-5">
        <router-link to="/see-applicants"> Show Applicants</router-link>
      </div>
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
  name: 'JobList',
  data() {
    return {
      columns: [
        'Title',
        'Description',
        'Number of People',
        'Last Application Date',
      ],
      jobs: [],
    };
  },
  methods: {
    async getData() {
      try {
        const response = await fetch('http://localhost:8070/job/job-list');
        this.jobs = await response.json();
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
