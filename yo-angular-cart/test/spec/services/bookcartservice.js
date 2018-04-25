'use strict';

describe('Service: BookCartService', function () {

  // load the service's module
  beforeEach(module('yoCartApp'));

  // instantiate service
  var BookCartService;
  beforeEach(inject(function (_BookCartService_) {
    BookCartService = _BookCartService_;
  }));

  it('should do something', function () {
    expect(!!BookCartService).toBe(true);
  });

});
