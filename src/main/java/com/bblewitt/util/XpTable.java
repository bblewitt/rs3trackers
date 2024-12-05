package main.java.com.bblewitt.util;

import java.util.HashMap;
import java.util.Map;

public class XpTable {
    private static final Map<Integer, Integer> XP_TABLE = new HashMap<>();
    private static final Map<Integer, Integer> ELITE_XP_TABLE = new HashMap<>();

    static {
        XP_TABLE.put(1, 0);
        XP_TABLE.put(2, 83);
        XP_TABLE.put(3, 174);
        XP_TABLE.put(4, 276);
        XP_TABLE.put(5, 388);
        XP_TABLE.put(6, 512);
        XP_TABLE.put(7, 650);
        XP_TABLE.put(8, 801);
        XP_TABLE.put(9, 969);
        XP_TABLE.put(10, 1154);
        XP_TABLE.put(11, 1358);
        XP_TABLE.put(12, 1584);
        XP_TABLE.put(13, 1833);
        XP_TABLE.put(14, 2107);
        XP_TABLE.put(15, 2411);
        XP_TABLE.put(16, 2746);
        XP_TABLE.put(17, 3115);
        XP_TABLE.put(18, 3523);
        XP_TABLE.put(19, 3973);
        XP_TABLE.put(20, 4470);
        XP_TABLE.put(21, 5018);
        XP_TABLE.put(22, 5624);
        XP_TABLE.put(23, 6291);
        XP_TABLE.put(24, 7028);
        XP_TABLE.put(25, 7842);
        XP_TABLE.put(26, 8740);
        XP_TABLE.put(27, 9730);
        XP_TABLE.put(28, 10824);
        XP_TABLE.put(29, 12031);
        XP_TABLE.put(30, 13363);
        XP_TABLE.put(31, 14833);
        XP_TABLE.put(32, 16456);
        XP_TABLE.put(33, 18247);
        XP_TABLE.put(34, 20224);
        XP_TABLE.put(35, 22406);
        XP_TABLE.put(36, 24815);
        XP_TABLE.put(37, 27473);
        XP_TABLE.put(38, 30408);
        XP_TABLE.put(39, 33648);
        XP_TABLE.put(40, 37224);
        XP_TABLE.put(41, 41171);
        XP_TABLE.put(42, 45529);
        XP_TABLE.put(43, 50339);
        XP_TABLE.put(44, 55649);
        XP_TABLE.put(45, 61512);
        XP_TABLE.put(46, 67983);
        XP_TABLE.put(47, 75127);
        XP_TABLE.put(48, 83014);
        XP_TABLE.put(49, 91721);
        XP_TABLE.put(50, 101333);
        XP_TABLE.put(51, 111945);
        XP_TABLE.put(52, 123660);
        XP_TABLE.put(53, 136594);
        XP_TABLE.put(54, 150872);
        XP_TABLE.put(55, 166636);
        XP_TABLE.put(56, 184040);
        XP_TABLE.put(57, 203254);
        XP_TABLE.put(58, 224466);
        XP_TABLE.put(59, 247886);
        XP_TABLE.put(60, 273742);
        XP_TABLE.put(61, 302288);
        XP_TABLE.put(62, 333804);
        XP_TABLE.put(63, 368599);
        XP_TABLE.put(64, 407015);
        XP_TABLE.put(65, 449428);
        XP_TABLE.put(66, 496254);
        XP_TABLE.put(67, 547953);
        XP_TABLE.put(68, 605032);
        XP_TABLE.put(69, 668051);
        XP_TABLE.put(70, 737627);
        XP_TABLE.put(71, 814445);
        XP_TABLE.put(72, 899257);
        XP_TABLE.put(73, 992895);
        XP_TABLE.put(74, 1096278);
        XP_TABLE.put(75, 1210421);
        XP_TABLE.put(76, 1336443);
        XP_TABLE.put(77, 1475581);
        XP_TABLE.put(78, 1629200);
        XP_TABLE.put(79, 1798808);
        XP_TABLE.put(80, 1986068);
        XP_TABLE.put(81, 2192818);
        XP_TABLE.put(82, 2421087);
        XP_TABLE.put(83, 2673114);
        XP_TABLE.put(84, 2951373);
        XP_TABLE.put(85, 3258594);
        XP_TABLE.put(86, 3597792);
        XP_TABLE.put(87, 3972294);
        XP_TABLE.put(88, 4385776);
        XP_TABLE.put(89, 4842295);
        XP_TABLE.put(90, 5346332);
        XP_TABLE.put(91, 5902831);
        XP_TABLE.put(92, 6517253);
        XP_TABLE.put(93, 7195629);
        XP_TABLE.put(94, 7944614);
        XP_TABLE.put(95, 8771558);
        XP_TABLE.put(96, 9684577);
        XP_TABLE.put(97, 10692629);
        XP_TABLE.put(98, 11805606);
        XP_TABLE.put(99, 13034431);
        XP_TABLE.put(100, 14391160);
        XP_TABLE.put(101, 15889109);
        XP_TABLE.put(102, 17542976);
        XP_TABLE.put(103, 19368992);
        XP_TABLE.put(104, 21385073);
        XP_TABLE.put(105, 23611006);
        XP_TABLE.put(106, 26068632);
        XP_TABLE.put(107, 28782069);
        XP_TABLE.put(108, 31777943);
        XP_TABLE.put(109, 35085654);
        XP_TABLE.put(110, 38737661);
        XP_TABLE.put(111, 42769801);
        XP_TABLE.put(112, 47221641);
        XP_TABLE.put(113, 52136869);
        XP_TABLE.put(114, 57563718);
        XP_TABLE.put(115, 63555443);
        XP_TABLE.put(116, 70170840);
        XP_TABLE.put(117, 77474828);
        XP_TABLE.put(118, 85539082);
        XP_TABLE.put(119, 94442737);
        XP_TABLE.put(120, 104273167);

        ELITE_XP_TABLE.put(1, 0);
        ELITE_XP_TABLE.put(2, 830);
        ELITE_XP_TABLE.put(3, 1861);
        ELITE_XP_TABLE.put(4, 2902);
        ELITE_XP_TABLE.put(5, 3980);
        ELITE_XP_TABLE.put(6, 5126);
        ELITE_XP_TABLE.put(7, 6390);
        ELITE_XP_TABLE.put(8, 7787);
        ELITE_XP_TABLE.put(9, 9400);
        ELITE_XP_TABLE.put(10, 11275);
        ELITE_XP_TABLE.put(11, 13605);
        ELITE_XP_TABLE.put(12, 16372);
        ELITE_XP_TABLE.put(13, 19656);
        ELITE_XP_TABLE.put(14, 23546);
        ELITE_XP_TABLE.put(15, 28138);
        ELITE_XP_TABLE.put(16, 33520);
        ELITE_XP_TABLE.put(17, 39809);
        ELITE_XP_TABLE.put(18, 47109);
        ELITE_XP_TABLE.put(19, 55535);
        ELITE_XP_TABLE.put(20, 64802);
        ELITE_XP_TABLE.put(21, 77190);
        ELITE_XP_TABLE.put(22, 90811);
        ELITE_XP_TABLE.put(23, 106221);
        ELITE_XP_TABLE.put(24, 123573);
        ELITE_XP_TABLE.put(25, 143025);
        ELITE_XP_TABLE.put(26, 164742);
        ELITE_XP_TABLE.put(27, 188893);
        ELITE_XP_TABLE.put(28, 215651);
        ELITE_XP_TABLE.put(29, 245196);
        ELITE_XP_TABLE.put(30, 277713);
        ELITE_XP_TABLE.put(31, 316311);
        ELITE_XP_TABLE.put(32, 358547);
        ELITE_XP_TABLE.put(33, 404634);
        ELITE_XP_TABLE.put(34, 454796);
        ELITE_XP_TABLE.put(35, 509259);
        ELITE_XP_TABLE.put(36, 568254);
        ELITE_XP_TABLE.put(37, 632019);
        ELITE_XP_TABLE.put(38, 700797);
        ELITE_XP_TABLE.put(39, 774834);
        ELITE_XP_TABLE.put(40, 854383);
        ELITE_XP_TABLE.put(41, 946227);
        ELITE_XP_TABLE.put(42, 1044569);
        ELITE_XP_TABLE.put(43, 1149696);
        ELITE_XP_TABLE.put(44, 1261903);
        ELITE_XP_TABLE.put(45, 1381488);
        ELITE_XP_TABLE.put(46, 1508756);
        ELITE_XP_TABLE.put(47, 1644015);
        ELITE_XP_TABLE.put(48, 1787581);
        ELITE_XP_TABLE.put(49, 1939773);
        ELITE_XP_TABLE.put(50, 2100917);
        ELITE_XP_TABLE.put(51, 2283490);
        ELITE_XP_TABLE.put(52, 2476369);
        ELITE_XP_TABLE.put(53, 2679907);
        ELITE_XP_TABLE.put(54, 2894505);
        ELITE_XP_TABLE.put(55, 3120508);
        ELITE_XP_TABLE.put(56, 3358307);
        ELITE_XP_TABLE.put(57, 3608290);
        ELITE_XP_TABLE.put(58, 3870846);
        ELITE_XP_TABLE.put(59, 4146374);
        ELITE_XP_TABLE.put(60, 4435275);
        ELITE_XP_TABLE.put(61, 4758122);
        ELITE_XP_TABLE.put(62, 5096111);
        ELITE_XP_TABLE.put(63, 5449685);
        ELITE_XP_TABLE.put(64, 5819299);
        ELITE_XP_TABLE.put(65, 6205407);
        ELITE_XP_TABLE.put(66, 6608473);
        ELITE_XP_TABLE.put(67, 7028964);
        ELITE_XP_TABLE.put(68, 7467354);
        ELITE_XP_TABLE.put(69, 7924122);
        ELITE_XP_TABLE.put(70, 8399751);
        ELITE_XP_TABLE.put(71, 8925664);
        ELITE_XP_TABLE.put(72, 9472665);
        ELITE_XP_TABLE.put(73, 10041285);
        ELITE_XP_TABLE.put(74, 10632061);
        ELITE_XP_TABLE.put(75, 11245538);
        ELITE_XP_TABLE.put(76, 11882262);
        ELITE_XP_TABLE.put(77, 12542789);
        ELITE_XP_TABLE.put(78, 13227679);
        ELITE_XP_TABLE.put(79, 13937496);
        ELITE_XP_TABLE.put(80, 14672812);
        ELITE_XP_TABLE.put(81, 15478994);
        ELITE_XP_TABLE.put(82, 16313404);
        ELITE_XP_TABLE.put(83, 17176661);
        ELITE_XP_TABLE.put(84, 18069395);
        ELITE_XP_TABLE.put(85, 18992239);
        ELITE_XP_TABLE.put(86, 19945833);
        ELITE_XP_TABLE.put(87, 20930821);
        ELITE_XP_TABLE.put(88, 21947856);
        ELITE_XP_TABLE.put(89, 22997593);
        ELITE_XP_TABLE.put(90, 24080695);
        ELITE_XP_TABLE.put(91, 25259906);
        ELITE_XP_TABLE.put(92, 26475754);
        ELITE_XP_TABLE.put(93, 27728955);
        ELITE_XP_TABLE.put(94, 29020233);
        ELITE_XP_TABLE.put(95, 30350318);
        ELITE_XP_TABLE.put(96, 31719944);
        ELITE_XP_TABLE.put(97, 33129852);
        ELITE_XP_TABLE.put(98, 34580790);
        ELITE_XP_TABLE.put(99, 36073511);
        ELITE_XP_TABLE.put(100, 37608773);
        ELITE_XP_TABLE.put(101, 39270442);
        ELITE_XP_TABLE.put(102, 40978509);
        ELITE_XP_TABLE.put(103, 42733789);
        ELITE_XP_TABLE.put(104, 44537107);
        ELITE_XP_TABLE.put(105, 46389292);
        ELITE_XP_TABLE.put(106, 48291180);
        ELITE_XP_TABLE.put(107, 50243611);
        ELITE_XP_TABLE.put(108, 52247435);
        ELITE_XP_TABLE.put(109, 54303504);
        ELITE_XP_TABLE.put(110, 56412678);
        ELITE_XP_TABLE.put(111, 58575823);
        ELITE_XP_TABLE.put(112, 60793812);
        ELITE_XP_TABLE.put(113, 63067521);
        ELITE_XP_TABLE.put(114, 65397835);
        ELITE_XP_TABLE.put(115, 67785643);
        ELITE_XP_TABLE.put(116, 70231841);
        ELITE_XP_TABLE.put(117, 72737330);
        ELITE_XP_TABLE.put(118, 75303019);
        ELITE_XP_TABLE.put(119, 77929820);
        ELITE_XP_TABLE.put(120, 80618654);
        ELITE_XP_TABLE.put(121, 83370445);
        ELITE_XP_TABLE.put(122, 86186124);
        ELITE_XP_TABLE.put(123, 89066630);
        ELITE_XP_TABLE.put(124, 92012904);
        ELITE_XP_TABLE.put(125, 95025896);
        ELITE_XP_TABLE.put(126, 98106559);
        ELITE_XP_TABLE.put(127, 101255855);
        ELITE_XP_TABLE.put(128, 104474750);
        ELITE_XP_TABLE.put(129, 107764216);
        ELITE_XP_TABLE.put(130, 111125230);
        ELITE_XP_TABLE.put(131, 114558777);
        ELITE_XP_TABLE.put(132, 118065845);
        ELITE_XP_TABLE.put(133, 121647430);
        ELITE_XP_TABLE.put(134, 125304532);
        ELITE_XP_TABLE.put(135, 129038159);
        ELITE_XP_TABLE.put(136, 132849323);
        ELITE_XP_TABLE.put(137, 136739041);
        ELITE_XP_TABLE.put(138, 140708338);
        ELITE_XP_TABLE.put(139, 144758242);
        ELITE_XP_TABLE.put(140, 148889790);
        ELITE_XP_TABLE.put(141, 153104021);
        ELITE_XP_TABLE.put(142, 157401983);
        ELITE_XP_TABLE.put(143, 161784728);
        ELITE_XP_TABLE.put(144, 166253312);
        ELITE_XP_TABLE.put(145, 170808801);
        ELITE_XP_TABLE.put(146, 175452262);
        ELITE_XP_TABLE.put(147, 180184770);
        ELITE_XP_TABLE.put(148, 185007406);
        ELITE_XP_TABLE.put(149, 189921255);
        ELITE_XP_TABLE.put(150, 194927409);
    }

    public static int getTargetXp(int level, boolean isInvention) {
        Map<Integer, Integer> table = isInvention ? ELITE_XP_TABLE : XP_TABLE;
        return table.getOrDefault(level, 200000000);
    }
}
