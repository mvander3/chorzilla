'use strict';

/* App Module */

var chorzillaApp = angular.module('chorzillaApp', [
  'ngRoute',
  'chorzillaAnimations',

  'chorzillaControllers',
  'chorzillaFilters',
  'chorzillaServices'
]);

chorzillaApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/chorzilla', {
        templateUrl: 'html/chore-list.html',
        controller: 'ChoreListCtrl'
      }).
      when('/chorzilla/:choreId', {
        templateUrl: 'html/chore-detail.html',
        controller: 'ChoreDetailCtrl'
      }).
      otherwise({
        redirectTo: '/chorzilla'
      }); 
  }]);
