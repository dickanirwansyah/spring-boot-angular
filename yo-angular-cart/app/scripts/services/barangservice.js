'use strict';

/**
 * @ngdoc service
 * @name yoCartApp.BarangService
 * @description
 * # BarangService
 * Factory in the yoCartApp.
 */
angular.module('yoCartApp')
  .factory('BarangService', function ($resource, $http) {
    
    return {
        barangResource:$resource('http://localhost:8080/api/barang'),
        get:function(param, callback){
          return this.barangResource(param, callback);
        },

        listBarang:function(){
          return this.barangResource.query();
        }   
    };
  });
