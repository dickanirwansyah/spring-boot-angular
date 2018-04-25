'use strict';

/**
 * @ngdoc function
 * @name yoCartApp.controller:BookcartCtrl
 * @description
 * # BookcartCtrl
 * Controller of the yoCartApp
 */
angular.module('yoCartApp')
  .controller('BookcartCtrl', function (BookCartService, $http, $scope, $cookies) {

    $scope.listbook = BookCartService.listBookCart();
    $scope.cart = [];
    $scope.total = 0;

    //cookies total
    if(!angular.isUndefined($cookies.get('total'))){
      $scope.total = parseFloat($cookies.get('total'));
    }

    //cookies cart
    if(!angular.isUndefined($cookies.get('cart'))){
      $scope.cart = $cookies.getObject('cart');
    }

    $scope.addToCart = function(buku){
        if($scope.cart.length === 0){
          buku.count = 1;
          $scope.cart.push(buku);
        }else{
          var repeat = false;
          for(var i =0; i<$scope.cart.length; i++){
            if($scope.cart[i].idbarang === buku.idbarang){
              repeat = true;
              $scope.cart[i].count += 1;
            }
          }
          if(!repeat){
            buku.count = 1;
            $scope.cart.push(buku);
          }
        }
        var expireDate = new Date();
        expireDate.setDate(expireDate.getDate() + 1);
        $cookies.putObject('cart', $scope.cart, {'expires': expireDate});
        $scope.cart = $cookies.getObject('cart');
        $scope.total += parseFloat(buku.unitprice);
        $cookies.put('total', $scope.total, {'expires': expireDate});
        console.log('add to cart : '+buku.idbarang+' Total : '+$scope.total);
    };

    $scope.removeItem = function(buku){
      if(buku.count > 1){
        buku.count -= 1;
        var expireDate = new Date();
        expireDate.setDate(expireDate.getDate() + 1);
        $cookies.putObject('cart', $scope.cart, {'expires': expireDate});
        $scope.cart = $cookies.getObject('cart');
      }else if(buku.count === 1){
        var index = $scope.cart.indexOf(buku);
        $scope.cart.splice(index, 1);
        expireDate = new Date();
        expireDate.setDate(expireDate.getDate() + 1);
        $cookies.putObject('cart', $scope.cart, {'expires': expireDate});
        $scope.cart = $cookies.getObject('cart');
      }
      $scope.total -= parseFloat(buku.unitprice);
      $cookies.put('total', $scope.total, {'expires': expireDate});
    };

  });
