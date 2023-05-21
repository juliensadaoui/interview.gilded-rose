package io.jsadaoui.kata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {


  @Test
  void shouldBehaveLikeGoldenMaster() {
    GildedRose rose = new GildedRose(ItemsProvider.get());
    GildedRoseGolden golden = new GildedRoseGolden(ItemsProvider.get());

    for (int day = 0; day < 100; day++) {
      rose.updateQuality();
      golden.updateQuality();

      assertThat(rose.getItems())
              .extracting(item -> item.sellIn)
              .containsExactly(Arrays.stream(golden.items).map(item -> item.sellIn).toArray(Integer[]::new));
      assertThat(rose.getItems())
              .extracting(item -> item.quality)
              .containsExactly(Arrays.stream(golden.items).map(item -> item.quality).toArray(Integer[]::new));
    }
  }
}