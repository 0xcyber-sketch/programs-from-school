package org.acme.persistance;

import org.acme.domain.Card;
import org.acme.domain.PokemonCard;
import org.acme.domain.YugiohCard;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Transactional
public class Rep {

   private HashMap<Integer, PokemonCard> pokemonCardMap = new HashMap<>();
   private HashMap<Integer, YugiohCard> yugiohCardMap = new HashMap<>();

   public Rep() {
      pokemonCardMap.put(1, new PokemonCard(1, "Biddof",12, 20 ,
              "Biddof is a little beaver like creature", "Normal", false, 30));
   }


   public List<PokemonCard> getPokemonCards() {
      return pokemonCardMap.values().stream().collect(Collectors.toList());
   }
   public List<YugiohCard> getYugiohCards() {
      return yugiohCardMap.values().stream().collect(Collectors.toList());
   }

   public Card createCard(Card card) {
      try {
      if (card instanceof PokemonCard) {
         pokemonCardMap.put(card.getID(), (PokemonCard) (card));
      }
      else if (card instanceof  YugiohCard) {
         yugiohCardMap.put(card.getID(), (YugiohCard) (card));

      }}
      catch (Exception e) {
         throw e;
      }
      return card;
   }

   public PokemonCard getPokemonCard(int id) {
      return pokemonCardMap.get(id);
   }

   public YugiohCard getYugiohCard(int id) {
      return yugiohCardMap.get(id);
   }

}
