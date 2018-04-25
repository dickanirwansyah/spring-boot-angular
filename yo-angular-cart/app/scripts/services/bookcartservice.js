'use strict';

/**
 * @ngdoc service
 * @name yoCartApp.BookCartService
 * @description
 * # BookCartService
 * Factory in the yoCartApp.
 */
angular.module('yoCartApp')
  .factory('BookCartService', function ($resource, $http) {
    return {
        bookCartServices:$resource('http://localhost:8080/api/barang'),
        get:function(param, callback){
          return this.bookcartservice(param, callback);
        },

        listBookCart:function(){
          return this.bookCartServices.query();
        }
    };
  });
