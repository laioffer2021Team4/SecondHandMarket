import React, {Component} from 'react';
import {Descriptions} from "antd";
import { Badge } from "shards-react";

class ProductInfo extends Component {

  // state = {
  //   productInfo: null
  // }

  render() {
    const productInfo = this.props.info;
    return (
      <div>
        <Descriptions style={{fontSize: '18px', border: "1px solid #dddddd", borderCollapse: "collapse", width: "100%"}}>
          <Descriptions.Item label="Price: " span={3}>${productInfo.price}</Descriptions.Item>
          <Descriptions.Item label="Post Date: " span={3}>{productInfo.postDate}</Descriptions.Item>
          <Descriptions.Item label="Condition: " span={3}>{productInfo.condition}</Descriptions.Item>
          <Descriptions.Item label="Status: " span={3}>
            {
              productInfo.sold ?
                <Badge theme="danger">sold</Badge>
                :
                <Badge theme="success">on sale</Badge>
            }
          </Descriptions.Item>
          <Descriptions.Item label="Descriptions: " span={3}>{productInfo.description}</Descriptions.Item></Descriptions>
      </div>
    );
  }
}

export default ProductInfo;
