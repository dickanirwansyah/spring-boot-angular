'use strict';

describe('Controller: BarangCtrl', function () {

  // load the controller's module
  beforeEach(module('yoCartApp'));

  var BarangCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    BarangCtrl = $controller('BarangCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(BarangCtrl.awesomeThings.length).toBe(3);
  });
});
