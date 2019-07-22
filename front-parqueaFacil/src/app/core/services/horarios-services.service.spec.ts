import { TestBed } from '@angular/core/testing';

import { HorariosServicesService } from './horarios-services.service';

describe('HorariosServicesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HorariosServicesService = TestBed.get(HorariosServicesService);
    expect(service).toBeTruthy();
  });
});
