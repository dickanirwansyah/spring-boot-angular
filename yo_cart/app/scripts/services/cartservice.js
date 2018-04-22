'use strict';

/**
 * @ngdoc service
 * @name yoCartApp.CartService
 * @description
 * # CartService
 * Factory in the yoCartApp.
 */
angular.module('yoCartApp')
  .factory('CartService', function ($resource, $http) {
   
    return {
        cartResource:$resource('http://localhost:8080/api/shopping/not_purchased'),
        get:function(param, callback){
          return this.cartResource(param, callback);
        },

        listShoppingCart: function(){
          return this.cartResource.query();
        },

        cartUpdate:function(data){
          if(data != null){
            return $http.post('http://localhost:8080/api/shopping/updated'+data.idshopping, data);
          }
        }
    };
  });
