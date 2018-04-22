'use strict';

/**
 * @ngdoc function
 * @name yoCartApp.controller:CartCtrl
 * @description
 * # CartCtrl
 * Controller of the yoCartApp
 */
angular.module('yoCartApp')
  .controller('CartCtrl', function ($http, $scope, CartService) {

      $scope.shoppingCart = CartService.listShoppingCart();
      
      $scope.updatedCart = function(shoppingCart, stock){
        $scope.shoppingCart = {};
        if($scope.shoppingCart.stock = stock == null){
          $scope.shoppingCart.stock = shoppingCart.stock;
        }else{
          $scope.shoppingCart.stock = stock;
        }
        $http.post('http://localhost:8080/api/shopping/updated/'+shoppingCart.idshopping, $scope.shoppingCart);
        alert('update successfully');
        window.location.reload();
      }

  });
