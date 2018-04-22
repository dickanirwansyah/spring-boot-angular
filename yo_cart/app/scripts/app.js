'use strict';

/**
 * @ngdoc overview
 * @name yoCartApp
 * @description
 * # yoCartApp
 *
 * Main module of the application.
 */
angular
  .module('yoCartApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/Barang', {
        templateUrl: 'views/barang.html',
        controller: 'BarangCtrl',
        controllerAs: 'Barang'
      })
      .when('/factory', {
        templateUrl: 'views/factory.html',
        controller: 'FactoryCtrl',
        controllerAs: 'factory'
      })
      .when('/cart', {
        templateUrl: 'views/cart.html',
        controller: 'CartCtrl',
        controllerAs: 'cart'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
