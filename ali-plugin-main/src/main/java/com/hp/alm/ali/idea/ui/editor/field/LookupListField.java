/*
 * Copyright 2013 Hewlett-Packard Development Company, L.P
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.alm.ali.idea.ui.editor.field;

import com.hp.alm.ali.idea.model.Entity;
import com.hp.alm.ali.idea.model.Field;

import java.util.List;

public class LookupListField extends AbstractListField {

    public LookupListField(List<String> list, Field field, Entity entity, boolean editable, boolean forceRequired) {
        super(field.getLabel(), field.isRequired() || forceRequired, editable);

        initializeValues(list, entity.getPropertyValue(field.getName()));
    }

    public LookupListField(List<String> list, Field field, Entity entity, boolean editable) {
        this(list, field, entity, editable, false);
    }

    public String getValue() {
        String selectedItem = getSelectedItem();
        return selectedItem == null? "": selectedItem;
    }
}
