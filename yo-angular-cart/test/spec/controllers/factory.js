'use strict';

describe('Controller: FactoryCtrl', function () {

  // load the controller's module
  beforeEach(module('yoCartApp'));

  var FactoryCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FactoryCtrl = $controller('FactoryCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(FactoryCtrl.awesomeThings.length).toBe(3);
  });
});
