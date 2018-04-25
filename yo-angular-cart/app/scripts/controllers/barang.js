'use strict';

/**
 * @ngdoc function
 * @name yoCartApp.controller:BarangCtrl
 * @description
 * # BarangCtrl
 * Controller of the yoCartApp
 */
angular.module('yoCartApp')
  .controller('BarangCtrl', function ($scope, $http, BarangService) {

      $scope.barangList = BarangService.listBarang();
      $scope.itemCounter = 0;

      $scope.addToCart = function(barang, stock){
        console.log("successfully : "+barang+" "+stock)
        $scope.itemCounter += 1;
        $scope.shoppingCart = {};
        $scope.shoppingCart.barang = barang;
        $scope.shoppingCart.status = "NOT_PURCHASED";

        if(angular.isUndefined(stock)){
          $scope.shoppingCart.stock = 1;
        }else{
          $scope.shoppingCart.stock = stock;
        }
        $http.post('http://localhost:8080/api/shopping/created', $scope.shoppingCart);
      }
  });
