import Vue from 'vue';
import VueRouter from 'vue-router';

// eslint-disable-next-line import/extensions
import Login from '../components/Login';
// eslint-disable-next-line import/extensions
import Home from '../components/Home';
// eslint-disable-next-line import/extensions
import ApplicantForm from '../components/ApplicantForm';
// eslint-disable-next-line import/extensions
import Admin from '../views/Admin';
// eslint-disable-next-line import/extensions
import AddJob from '../components/AddJob';
// eslint-disable-next-line import/extensions
import SeeApplicants from '../components/SeeApplicants';

Vue.use(VueRouter);

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/applicant-form',
    name: 'ApplicantForm',
    component: ApplicantForm,
  },
  {
    path: '/admin',
    name: 'Admin',
    component: Admin,
  },
  {
    path: '/add-job',
    name: 'AddJob',
    component: AddJob,
  },
  {
    path: '/see-applicants',
    name: 'SeeApplicants',
    component: SeeApplicants,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
