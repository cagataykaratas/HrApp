<template>
  <div class="container">
    <div class="form-container">
      <form @submit.prevent="postData" method="post">
        <h3>ADD JOB</h3>
        <div class="form-group">
          <label>Admin Email Address:</label>
          <input required type="email" v-model="posts.email" class="form-control form-control-lg" >
        </div>
        <div class="form-group">
          <label>Job Title:</label>
          <input required type="text" v-model="posts.title" class="form-control form-control-lg">
        </div>
        <div class="form-group">
          <label>Description</label>
          <input required type="text" v-model="posts.description"
                 class="form-control form-control-lg" >
        </div>
        <div class="form-group">
          <label>Number Of Required Person</label>
          <input required type="text" v-model="posts.numberOfPeople"
                 class="form-control form-control-lg">
        </div>
        <div class="form-group">
          <label>Last Application Date</label>
          <input required type="text" v-model="posts.applicationDate"
                 class="form-control form-control-lg">
        </div>
        <button type="submit" class="btn btn-dark btn-lg btn-block mt-3"> Add </button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AddJob',
  data() {
    return {
      posts: {
        email: '',
        title: '',
        description: '',
        numberOfPeople: '',
        applicationDate: '',
      },
    };
  },
  methods: {
    postData(e) {
      this.axios.post('http://localhost:8070/hr/add-job', this.posts)
        .then((result) => {
          // eslint-disable-next-line no-console
          console.warn(result);
        });
      e.preventDefault();
    },
  },
};
</script>

<style scoped>

</style>
