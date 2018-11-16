import Vue from 'vue'
import Router from 'vue-router'
import libraryMain from '@/components/library/libraryMain.vue'
import libraryFrom from '@/components/library/libraryFrom.vue'
import usersMain from '@/components/users/usersMain.vue'
import quietMain from '@/components/quiet/quietMain.vue'
import newMain from '@/components/new/newMain.vue'
import logManager from '@/components/logdata/logManager.vue'
import logUser from '@/components/logdata/logUser.vue'




import Main from '@/components/Main.vue'
import Error from '@/components/error.vue'

import routerconf from "./config"


routerconf.routers.push({
  path: '/',
  name: 'Main',
  component: Main
});
routerconf.routers.push({
  path: '*',
  component: Error
});


routerconf.routers.push({
  path: '/libraryMain',
  name: 'libraryMain',
  component: libraryMain
});
routerconf.routers.push({
  path: '/libraryMain/libraryFrom',
  name: 'libraryFrom',
  component: libraryFrom
});

routerconf.routers.push({
  path: '/usersMain',
  name: 'usersMain',
  component: usersMain
});

routerconf.routers.push({
  path: '/quietMain',
  name: 'quietMain',
  component: quietMain
});

routerconf.routers.push({
  path: '/newMain',
  name: 'newMain',
  component: newMain
});

routerconf.routers.push({
  path: '/logManager',
  name: 'logManager',
  component: logManager
});

routerconf.routers.push({
  path: '/logUser',
  name: 'logUser',
  component: logUser
});
Vue.use(Router)

export default new Router({
  routes: routerconf.routers
})
