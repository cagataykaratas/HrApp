<template>
  <div id="header">
    <nav class="navbar shadow rounded">
      <div class="container">
        <ul class="nav navbar-nav flex-row float-right m-auto">
          <li class="nav-item">
            <router-link class="nav-link pr-3 text-black" to="/login">Sign in</router-link>
          </li>
        </ul>
      </div>
    </nav>
    <form @submit.prevent="postData" method="post" class="w-50 m-auto mt-5">
      <h3>Sign In Form</h3>

      <div class="form-group">
        <label>Email address</label>
        <input required type="email"  v-model="posts.email"
               class="form-control form-control-lg" /><br>
      </div>

      <div class="form-group">
        <label>Password</label>
        <input required type="password" v-model="posts.password"
               class="form-control form-control-lg" /><br>
      </div>

      <button type="submit" class="btn btn-dark btn-lg btn-block"> Sign In </button>
    </form>
  </div>
</template>

<script>
import Vue from 'vue';
// eslint-disable-next-line import/no-extraneous-dependencies
import axios from 'axios';
import VueAxios from 'vue-axios';

Vue.use(VueAxios, axios);
export default {
  name: 'Login',
  data() {
    return {
      posts: {
        email: '',
        password: '',
      },
    };
  },
  methods: {
    postData(e) {
      this.axios.post('http://localhost:8070/token/login', this.posts)
        .then((result) => {
          // eslint-disable-next-line no-console
          console.warn(result);
        });
      e.preventDefault();
    },
  },
};
</script>
