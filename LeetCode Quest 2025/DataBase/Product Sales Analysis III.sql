-- import pandas as pd

-- def sales_analysis(sales: pd.DataFrame) -> pd.DataFrame:
--     # Find each product's first sale year
--     first_years = (
--         sales.groupby("product_id")["year"]
--         .min()
--         .reset_index()
--         .rename(columns={"year": "first_year"})
--     )

--     # Merge to get rows that belong to each product's first year
--     merged = sales.merge(first_years, on="product_id")

--     # Filter only rows where year == first_year
--     result = merged[merged["year"] == merged["first_year"]]

--     # Select only the columns required by LeetCode
--     return result[["product_id", "first_year", "quantity", "price"]]
