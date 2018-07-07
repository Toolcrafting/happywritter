#Schema documentation

Generated by MySQL Workbench Model Documentation v1.0.0 - Copyright (c) 2015 Hieu Le

##Table: `Kunde`

###Description: 



###Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   |   |
| `vorname` | VARCHAR(45) |  |   |   |
| `nachname` | VARCHAR(45) |  |   |   |
| `strasse` | VARCHAR(45) |  |   |   |
| `ort` | VARCHAR(45) |  |   |   |
| `plz` | VARCHAR(45) |  |   |   |
| `tel` | VARCHAR(45) |  |   |   |
| `kundeSeit` | TIMESTAMP |  |   |   |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |


##Table: `Bestellung`

###Description: 



###Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   |   |
| `Kunde_id` | INT | PRIMARY, Not null |   |  **foreign key** to column `id` on table `Kunde`. |
| `datum` | TIMESTAMP |  |   |   |
| `bemerkungen` | VARCHAR(255) |  |   |   |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id`, `Kunde_id` | PRIMARY |   |
| fk_Bestellung_Kunde_idx | `Kunde_id` | INDEX |   |


##Table: `Artikel`

###Description: 



###Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   |   |
| `bezeichnung` | VARCHAR(45) |  |   |   |
| `preis` | INT |  |   |   |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |


##Table: `BestellPosition`

###Description: 



###Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   |   |
| `Bestellung_id` | INT | PRIMARY, Not null |   |  **foreign key** to column `id` on table `Bestellung`. |
| `Artikel_id` | INT | PRIMARY, Not null |   |  **foreign key** to column `id` on table `Artikel`. |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id`, `Bestellung_id`, `Artikel_id` | PRIMARY |   |
| fk_BestellPosition_Bestellung1_idx | `Bestellung_id` | INDEX |   |
| fk_BestellPosition_Artikel1_idx | `Artikel_id` | INDEX |   |


##Table: `Inhalt`

###Description: 



###Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `id` | INT | PRIMARY, Auto increments, Not null |   |   |
| `name` | VARCHAR(45) |  |   |   |
| `preis` | INT |  |   |   |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `id` | PRIMARY |   |


##Table: `Konfiguration`

###Description: 



###Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `Artikel_id` | INT | PRIMARY, Not null, Unique |   |  **foreign key** to column `id` on table `Artikel`. |
| `Inhalt_id` | INT | PRIMARY, Not null, Unique |   |  **foreign key** to column `id` on table `Inhalt`. |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `Artikel_id`, `Inhalt_id` | PRIMARY |   |
| fk_Artikel_has_Inhalt_Inhalt1_idx | `Inhalt_id` | INDEX |   |
| fk_Artikel_has_Inhalt_Artikel1_idx | `Artikel_id` | INDEX |   |
| Artikel_id_UNIQUE | `Artikel_id` | UNIQUE |   |
| Inhalt_id_UNIQUE | `Inhalt_id` | UNIQUE |   |


##Table: `BestellteKonfiguration`

###Description: 



###Columns: 

| Column | Data type | Attributes | Default | Description |
| --- | --- | --- | --- | ---  |
| `BestellPosition_id` | INT | PRIMARY, Not null |   |  **foreign key** to column `id` on table `BestellPosition`. |
| `Inhalt_id` | INT | PRIMARY, Not null |   |  **foreign key** to column `id` on table `Inhalt`. |


### Indices: 

| Name | Columns | Type | Description |
| --- | --- | --- | --- |
| PRIMARY | `BestellPosition_id`, `Inhalt_id` | PRIMARY |   |
| fk_BestellPosition_has_Inhalt_Inhalt1_idx | `Inhalt_id` | INDEX |   |
| fk_BestellPosition_has_Inhalt_BestellPosition1_idx | `BestellPosition_id` | INDEX |   |

