'use strict';

describe('Controller: BookcartCtrl', function () {

  // load the controller's module
  beforeEach(module('yoCartApp'));

  var BookcartCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    BookcartCtrl = $controller('BookcartCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(BookcartCtrl.awesomeThings.length).toBe(3);
  });
});
