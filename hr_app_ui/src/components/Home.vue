<template>
  <div class="cont">
    <nav class="navbar shadow rounded">
      <div class="container">
        <ul class="nav navbar-nav flex-row float-right m-auto">
          <li class="nav-item">
            <router-link class="nav-link pr-3 text-black" to="/login">Sign in</router-link>
          </li>
        </ul>
      </div>
    </nav>
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
            <td><router-link to="/applicant-form">
              <input type="button" value="Apply" class="rounded"></router-link></td>
          </tr>
        </tbody>
      </table>
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
        'Apply',
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
