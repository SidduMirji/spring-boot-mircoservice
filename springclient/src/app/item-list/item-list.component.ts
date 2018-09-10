import {Component, OnInit} from '@angular/core';

import {GiphyService, ItemService} from '../shared';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css'],
  providers: [ItemService, GiphyService]
})
export class ItemListComponent implements OnInit {
  items: Array<any>;

  constructor(
      private itemService: ItemService, private giphyService: GiphyService) {}

  ngOnInit() {
    this.itemService.getAll().subscribe(data => {
      this.items = data;
      for (const item of this.items) {
        this.giphyService.get(item.name).subscribe(url => item.giphyUrl = url);
      }
    }, error => console.log(error))
  }
}
