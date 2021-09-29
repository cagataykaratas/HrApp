<template>
  <div class="container">
    <div class="applicant-container">
      <h3 class="mt-5">APPLICANTS</h3>
      <ul v-for="applicant in applicants" v-bind:key="applicant.id" class="pt-3">
        <li>{{applicant.name}} --> {{applicant.email}}</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SeeApplicants',
  data() {
    return {
      applicants: [],
    };
  },
  methods: {
    async getData() {
      try {
        const response = await fetch('http://localhost:8070/applicant/get-applicants');
        this.applicants = await response.json();
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
