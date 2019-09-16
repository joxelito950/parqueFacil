import { TestBed } from '@angular/core/testing';

import { ParqueaderosServiceService } from './parqueaderos-service.service';

describe('ParqueaderosServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ParqueaderosServiceService = TestBed.get(ParqueaderosServiceService);
    expect(service).toBeTruthy();
  });
});
