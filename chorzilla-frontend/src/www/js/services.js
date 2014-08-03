'use strict';

/* Services */

var chorzillaServices = angular.module('chorzillaServices', ['ngResource']);

chorzillaServices.factory('Chore', ['$resource',
  function($resource){
    return $resource('chores/:choreId?name=:name', {}, {
      query: {method:'GET', params:{choreId:'',name:'Mike'}, isArray:true}
    });
  }]);
