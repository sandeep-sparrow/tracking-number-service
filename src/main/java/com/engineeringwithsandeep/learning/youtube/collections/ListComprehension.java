package com.engineeringwithsandeep.learning.youtube.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListComprehension {

    public static void main(String[] args) {
        List<String> xyz_tags = new ArrayList<>();

        xyz_tags.add("status_in_progress");
        xyz_tags.add("assigned_at_1730880467445");
        xyz_tags.add("user_organization_here");
        xyz_tags.add("assigned_by_otm");
        xyz_tags.add("tool_mapcreator_moderation");
        xyz_tags.add("tasktype_conflation");
        xyz_tags.add("status_in_progress");
        xyz_tags.add("@admin1_irl");

        /* here is the code in which python does list comprehension, let's implement the same in java
            xyz_tags = ["status_completed" if tag == "status_in_progress" else tag for tag in xyz_tags]
         */

        xyz_tags = replaceStringValue(xyz_tags, "status_in_progress", "status_completed");

        System.out.println(xyz_tags);
    }

    private static List<String> replaceStringValue(List<String> data, String oldValue, String newValue) {
        return data.stream().map(tag -> tag.equals(oldValue) ? newValue : tag)
                .collect(Collectors.toList());
    }
}
