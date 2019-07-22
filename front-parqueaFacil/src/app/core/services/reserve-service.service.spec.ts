import { TestBed } from '@angular/core/testing';

import { ReserveServiceService } from './reserve-service.service';

describe('ReserveServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReserveServiceService = TestBed.get(ReserveServiceService);
    expect(service).toBeTruthy();
  });
});
