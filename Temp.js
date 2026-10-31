const TRADES = [
  
  // Mob Lasso Trade Injection
  ['minecraft:butcher', 3, ['16x minecraft:emerald', 'minecraft:lead'], 'moblassos:golden_lasso', 4, 15],
  ['minecraft:fisherman', 3, ['16x minecraft:emerald', 'minecraft:lead'], 'moblassos:aqua_lasso', 4, 15],
  ['minecraft:cleric', 3, ['24x minecraft:emerald', 'minecraft:chain'], 'moblassos:hostile_lasso', 4, 15],
  // Sophisticated Upgrades
    // Stack Upgrades
    ['minecraft:leatherworker', 3, ['8x minecraft:gold_block','sophisticatedbackpacks:stack_upgrade_tier_1'], 
      'sophisticatedbackpacks:stack_upgrade_tier_2', 4, 15],
    ['minecraft:leatherworker', 4, ['8x minecraft:diamond_block','sophisticatedbackpacks:stack_upgrade_tier_2'], 
      'sophisticatedbackpacks:stack_upgrade_tier_3', 4, 15],
    ['minecraft:leatherworker', 5, ['8x minecraft:netherite_block','sophisticatedbackpacks:stack_upgrade_tier_3'], 
      'sophisticatedbackpacks:stack_upgrade_tier_4', 4, 15],
    // Advanced Upgrades
    ['minecraft:toolsmith', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:tool_swapper_upgrade'], 
      'sophisticatedbackpacks:advanced_tool_swapper_upgrade', 3, 10],
    ['minecraft:weaponsmith', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:pickup_upgrade'], 
      'sophisticatedbackpacks:advanced_pickup_upgrade', 3, 10],
    ['minecraft:fletcher', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:refill_upgrade'], 
      'sophisticatedbackpacks:advanced_refill_upgrade', 3, 10],
    ['minecraft:cartographer', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:filter_upgrade'], 
      'sophisticatedbackpacks:advanced_filter_upgrade', 3, 10],
    ['minecraft:cartographer', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:restock_upgrade'], 
      'sophisticatedbackpacks:advanced_restock_upgrade', 3, 10],
    ['minecraft:cartographer', 4, ['16x minecraft:emerald', 'sophisticatedbackpacks:deposit_upgrade'], 
      'sophisticatedbackpacks:advanced_deposit_upgrade', 3, 15],
    ['minecraft:farmer', 3, ['24x minecraft:emerald', 'sophisticatedbackpacks:feeding_upgrade'], 
      'sophisticatedbackpacks:advanced_feeding_upgrade', 3, 10],
    ['minecraft:farmer', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:compacting_upgrade'], 
      'sophisticatedbackpacks:advanced_compacting_upgrade', 3, 10],
    ['minecraft:fisherman', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:pump_upgrade'], 
      'sophisticatedbackpacks:advanced_pump_upgrade', 3, 10],
    ['minecraft:butcher', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:smoking_upgrade'], 
      'sophisticatedbackpacks:auto_smoking_upgrade', 3, 10],
    ['minecraft:butcher', 4, ['24x minecraft:emerald', 'sophisticatedbackpacks:mob_catcher_upgrade'], 
      'sophisticatedbackpacks:advanced_mob_catcher_upgrade', 3, 15],
    ['minecraft:armorer', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:blasting_upgrade'], 
      'sophisticatedbackpacks:auto_blasting_upgrade', 3, 10],
    ['minecraft:mason', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:smelting_upgrade'], 
      'sophisticatedbackpacks:auto_smelting_upgrade', 3, 10],
    ['minecraft:cleric', 3, ['16x minecraft:emerald', 'sophisticatedbackpacks:alchemy_upgrade'], 
      'sophisticatedbackpacks:advanced_alchemy_upgrade', 3, 10],
    ['minecraft:toolsmith', 4, ['16x minecraft:emerald', 'sophisticatedbackpacks:magnet_upgrade'], 
      'sophisticatedbackpacks:advanced_magnet_upgrade', 3, 15],
    ['minecraft:armorer', 4, ['16x minecraft:emerald', 'sophisticatedstorage:hopper_upgrade'], 
      'sophisticatedstorage:advanced_hopper_upgrade',3, 15],
    // Locator Compasses
    ['minecraft:cartographer', 3, ['32x minecraft:emerald', 'minecraft:compass'], 
      'naturescompass:naturescompass', 3, 10],
    ['minecraft:cartographer', 3, ['32x minecraft:emerald', 'minecraft:compass'], 
      'explorerscompass:explorerscompass', 3, 10],
    // Building Wands
    ['minecraft:mason', 1, ['8x minecraft:emerald'], 'wands:stone_wand', 3, 10],
    ['minecraft:mason', 2, ['16x minecraft:emerald'], 'wands:copper_wand', 3, 10],
    ['minecraft:mason', 3, ['24x minecraft:emerald'], 'wands:iron_wand', 3, 10],
    ['minecraft:mason', 4, ['32x minecraft:emerald', 'minecraft:diamond'], 'wands:diamond_wand', 3, 10],
    ['minecraft:mason', 5, ['40x minecraft:emerald', 'minecraft:netherite_ingot'], 'wands:netherite_wand', 3, 10],  
]

MoreJS.wandererTrades(event => {
  event.addTrade(2, ['64x minecraft:emerald', 'minecraft:nether_star'], 'wands:creative_wand').maxUses(1)
})

MoreJS.villagerTrades(event => {
  TRADES.forEach (row => {
    let trade = event.addTrade(
        row[0],             // Profession
        row[1],             // Level 
        [].concat(row[2]),  // Cost
        row[3])             // Output 
        .maxUses(row[4]).villagerExperience(row[5])  // xp
  })
})


//MoreJS.villagerTrades(event => {
//  event.addTrade(
//    'minecraft:butcher', 3, 
//    TradeItem.of('minecraft:emerald', 12, 18),
//    'moblassos:golden_lasso'
//   )
//})