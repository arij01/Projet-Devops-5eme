import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlocListComponent } from './bloc-list.component';

describe('BlocListComponent', () => {
  let component: BlocListComponent;
  let fixture: ComponentFixture<BlocListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BlocListComponent]
    });
    fixture = TestBed.createComponent(BlocListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
