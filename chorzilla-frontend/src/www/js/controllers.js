'use strict';

/* Controllers */

var chorzillaControllers = angular.module('chorzillaControllers', []);

chorzillaControllers.controller('ChoreListCtrl', ['$scope', 'Chore',
  function($scope, Chore) {
    $scope.chores = Chore.query();
    $scope.orderProp = 'status';
  }]);

chorzillaControllers.controller('ChoreDetailCtrl', ['$scope', '$routeParams', 'Chore',
  function($scope, $routeParams, Chore) {
    $scope.chore = Chore.get({choreId: $routeParams.choreId}, function(chore) {
      $scope.mainImageUrl = chore.images[0];
    });

    $scope.setImage = function(imageUrl) {
      $scope.mainImageUrl = imageUrl;
    }
  }]);
